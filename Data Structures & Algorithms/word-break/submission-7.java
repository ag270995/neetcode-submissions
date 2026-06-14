class Solution {
    Map<Integer, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        map.put(s.length(), true);
        return wordBreak(s, set, 0);

    }

    public boolean wordBreak(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        int n = s.length();
        if (start == n) {
            map.put(start, true);
            return true;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (wordDict.contains(str)) {
                if (wordBreak(s, wordDict, i + 1)) {
                    return true;
                }
            }
        }
        map.put(start, false);
        return false;
    }
}
