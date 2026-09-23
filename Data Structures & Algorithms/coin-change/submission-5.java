class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = Integer.MAX_VALUE;
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = amount + 1;
            }
        }
          // Minimum coins needed to make amount 0 = 0
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }   
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                 // Don't take current coin
                dp[i][j] = dp[i][j - 1];
                if (i - coins[j - 1] >= 0) {
                    // Take current coin and find minimum
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - coins[j - 1]][j]);
                }
            }
        }
        return dp[amount][n] == amount + 1 ? -1 : dp[amount][n];
    }
}
