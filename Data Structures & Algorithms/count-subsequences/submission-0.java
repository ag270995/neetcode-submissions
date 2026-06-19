class Solution {
    public int numDistinct(String s, String t) {
        Map<String, Map<Integer, Integer>> memo = new HashMap<>();
        return numDistinct(s, t, 0, "", memo);
        
    }
    public int numDistinct(String s, String t, int i, String temp, Map<String, Map<Integer, Integer>> memo) {    
        if (memo.containsKey(temp) && memo.get(temp).containsKey(i)) {
            return memo.get(temp).get(i);
        }
        if (temp.length() == t.length()) {
            if (temp.equals(t)) {
                return 1;
            }
            return 0;
        }
        if (i >= s.length()) {
            return 0;
        }
        int res  = numDistinct(s, t, i + 1, temp + s.charAt(i), memo)+ numDistinct(s, t, i + 1, temp, memo);
        memo.computeIfAbsent(temp, k -> new HashMap<>()).put(i, res);
        return res;
    }
}
