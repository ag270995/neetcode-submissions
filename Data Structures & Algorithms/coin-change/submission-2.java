class Solution {
    public int coinChange(int[] coins, int amount) {    
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
        
    }

    int res = Integer.MAX_VALUE;

    public int helper(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                res = Math.min(res, 1 + helper(coins, amount - coins[i]));
            } 
        }
        return res;

        
        
    }
}
