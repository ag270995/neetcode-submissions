class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> countS = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int need = countT.size();
        int have = 0;
        int l = 0;
        int resLen = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int r = 0; r < s.length(); r++) {
            char charR = s.charAt(r);
            countS.put(charR, countS.getOrDefault(charR, 0) + 1);
            if (countT.containsKey(charR) && countS.get(charR).equals(countT.get(charR))) {
                have++;
            }
            while (have == need) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                
                char charL = s.charAt(l);
                countS.put(charL, countS.get(charL) - 1);
                if (countT.containsKey(charL) && countT.get(charL) > (countS.get(charL))) {
                    have--;
                }
                l++;

            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);

    }
}
