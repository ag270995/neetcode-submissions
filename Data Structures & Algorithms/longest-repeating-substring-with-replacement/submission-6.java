class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int n = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while((r - l + 1) - maxFreq(map) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    int maxFreq(Map<Character, Integer> map) {
        int freq = 0;
        for (Character c : map.keySet()) {
            freq = Math.max(freq, map.get(c));
        }
        return freq;
    }






}
