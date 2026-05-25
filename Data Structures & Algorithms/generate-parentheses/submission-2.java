class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, new StringBuilder());
        return res;
    }

    void helper(int n, int open, int close, StringBuilder sb) {
        if (sb.length() == 2*n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            helper(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            helper(n, open, ++close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
