class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            mapT.merge(t.charAt(i), 1, Integer::sum);
            mapS.put(t.charAt(i), 0);
        }
        int l = 0;
        int have = mapT.size();
        int need = 0;
        for (int r = 0; r < s.length(); r++) {

            if(mapS.containsKey(s.charAt(r))) {
                mapS.merge(s.charAt(r), 1, Integer::sum);
                if (mapS.get(s.charAt(r)).intValue() == mapT.get(s.charAt(r)).intValue()) {
                    need++;
                }
            }

            while (have == need) {
                if (r - l + 1 < minLen) {
                    minStart = l;
                    minLen = r - l + 1;
                }
                if (mapS.containsKey(s.charAt(l))) {
                    mapS.merge(s.charAt(l), -1, Integer::sum);
                    if (mapS.get(s.charAt(l)) < mapT.get(s.charAt(l))) {
                        need--;
                    }
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
