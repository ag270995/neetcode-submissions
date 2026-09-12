class Solution {
    //brute force approach
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            mapT.merge(t.charAt(i), 1, Integer::sum);
        }
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            mapS.merge(s.charAt(r), 1, Integer::sum);
            while (isMatch(mapS, mapT)) {
                if (r - l + 1 <= minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                mapS.merge(s.charAt(l), -1, Integer::sum);
                if (mapS.get(s.charAt(l)) <= 0) {
                    mapS.remove(s.charAt(l));
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    boolean isMatch(Map<Character, Integer> mapS, Map<Character, Integer> mapT) {
        for (Map.Entry<Character, Integer> entry : mapT.entrySet()) {
            Character key = entry.getKey();
            int value = entry.getValue();
            if (!mapS.containsKey(key)) {
                return false;
            }
            if (value > mapS.get(key)) {
                return false;
            }
        }
        return true;
    }
}