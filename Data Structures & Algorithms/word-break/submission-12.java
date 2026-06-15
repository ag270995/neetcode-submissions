class Solution {
    Map<Integer, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        map.put(s.length(), true);
        return wordBreak(s, wordDict, 0);

    }

    public boolean wordBreak(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        int n = s.length();
        if (start == n) {
            map.put(start, true);
            return true;
        }
        for (String word : wordDict) {
            int begin = start;
            int length = start + word.length();
            if (length <= n && s.substring(begin, length).equals(word)) {
                if (wordBreak(s, wordDict, start + word.length())) {
                    map.put(start, true);
                    return true;
                }
            }
            
        }
        map.put(start, false);
        return false;
    }
}
