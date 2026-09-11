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
        String res = "";
        int minLen = s.length();
        for (int i = 0; i < t.length(); i++) {
            mapT.merge(t.charAt(i), 1, Integer::sum);
        }
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            mapS.merge(s.charAt(r), 1, Integer::sum);
            while (isMatch(mapS, mapT)) {
                if (r - l + 1 <= minLen) {
                    res = s.substring(l, (r + 1));
                    minLen = res.length();
                }
                mapS.merge(s.charAt(l), -1, Integer::sum);
                if (mapS.get(s.charAt(l)) <= 0) {
                    mapS.remove(s.charAt(l));
                }
                l++;
            }
        }
        return res;
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
