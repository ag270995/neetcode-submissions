class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        Integer[][] memo = new Integer[m + 1][n + 1];
        return numDistinct(s, t, m, n, memo);
    }

    public int numDistinct(String s, String t, int m, int n, Integer[][] memo) {
        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }
        if (memo[m][n] != null) {
            return memo[m][n];
        }
        int res = 0;
        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            res = numDistinct(s, t, m - 1, n - 1, memo) + numDistinct(s, t, m - 1, n, memo);
        } else {
            res = numDistinct(s, t, m - 1, n, memo);
        }
        memo[m][n] = res;
        return res;
    }
}
