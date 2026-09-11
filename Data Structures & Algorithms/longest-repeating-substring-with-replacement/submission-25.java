class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int l = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            char charR = s.charAt(r);
            map.merge(charR, 1, Integer::sum);
            while ((r - l + 1) - max(map) > k) {
                map.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;

    }

    public int max(Map<Character, Integer> map) {
        return (int)map.values().stream().max((a, b) -> a - b).get();

    }
}
