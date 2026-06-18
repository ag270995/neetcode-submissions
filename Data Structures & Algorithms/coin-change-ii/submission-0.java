class Solution {
    public int change(int amount, int[] coins) {
        // return change(amount, coins, 0);

        int n = coins.length;

        int[][] dp = new int[amount + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i - coins[j - 1] >= 0) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }
        }
        return dp[amount][n];
        
    }


    public int change(int amount, int[] coins, int start) {
        int n = coins.length;
        if (start >= n || amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        int res = 0;
        for (int i = start; i < n; i++) {
            res += change(amount - coins[i], coins, i);
        }
        return res;
    }
}