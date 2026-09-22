class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length + 1][2];
        //for Buying = 0, for selling = 1
        return dfs(0, prices, 0, dp);
        
    }

    public int dfs(int index, int[] prices, int isBuying, Integer[][] dp) {
        int n = prices.length;
        if (index >= n) {
            return 0;
        }
        if (dp[index][isBuying] != null) {
            return dp[index][isBuying];
        }
        int cooldown = dfs(index + 1, prices, isBuying, dp);
        if (isBuying == 0) {
            int buying = dfs(index + 1, prices, 1, dp) - prices[index];
            dp[index][isBuying] = Math.max(cooldown, buying);
        } else {
            int selling = dfs(index + 2, prices, 0, dp) + prices[index];
            dp[index][isBuying] = Math.max(cooldown, selling);
        }
        return dp[index][isBuying];

    }


}
