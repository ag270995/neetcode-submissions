class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        int have = 0;
        int need = 0;
        for (int i = 0; i < t.length(); i++) {
            mapT.merge(t.charAt(i), 1, Integer::sum);
            mapS.put(t.charAt(i), 0);
        }
        need = mapT.size();
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char charR = s.charAt(r);
            if (mapS.containsKey(charR)) {
                mapS.merge(charR, 1, Integer::sum);
                if (mapS.get(charR).equals(mapT.get(charR))) {
                    have++;
                }
            }
            while (need == have) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }
                char charL = s.charAt(l);
                if (mapS.containsKey(charL)) {
                    mapS.merge(charL, -1, Integer::sum);
                    if (mapS.get(charL) < mapT.get(charL)) {
                        have--;
                    }
                }
                
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
