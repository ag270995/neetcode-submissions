class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[amount + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1]; // combination without using current coin
                if (i - coins[j - 1] >= 0) {
                    dp[i][j] += dp[i - coins[j - 1]][j]; // combination without using current coin
                }
            }
        }
        return dp[amount][n];
        
    }


    
}