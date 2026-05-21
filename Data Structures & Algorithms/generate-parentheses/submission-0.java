class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(0, 0, n, new StringBuilder());
        return res;
        
    }
    public void helper(int open, int close, int n, StringBuilder sb) {
        if (sb.length() == 2*n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            helper(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            helper(open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
