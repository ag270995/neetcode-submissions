class Solution {

    public int coinChange(int[] coins, int amount) {

        int res = Integer.MAX_VALUE;

        int n = coins.length;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        // Minimum coins needed to make amount 0 = 0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int j = 1; j <= n; j++) {

                if (i - coins[j - 1] >= 0) {

                    // Take the current coin and minimize the number of coins
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j - 1]]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}