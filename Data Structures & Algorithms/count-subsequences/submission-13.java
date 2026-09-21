class Solution {
    // bottoms up approach of previous memoization based approach
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= m; i++) {
            //base case which represents when t is exhaused
            dp[i][0] = 1; //if t is empty, there is only one which is to do nothing

        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
