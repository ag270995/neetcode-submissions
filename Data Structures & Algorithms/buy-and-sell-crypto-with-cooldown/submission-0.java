class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length + 1][2];
        return helper(0, tBuy, prices, dp);
    }
    int tBuy = 0;
    int tSell = 1;
    //transaction -> 0(buy), 1(sell)
    public int helper(int index, int transaction, int[] prices, Integer[][] dp) {
        int n = prices.length;
        if (index >= n) {
            return 0;
        }
        if (dp[index][transaction] != null) {
            return dp[index][transaction];
        }
         int cooldown = helper(index + 1, transaction, prices, dp);
        
        if (transaction == tBuy) {
            int buy = helper(index + 1, tSell, prices, dp) - prices[index];
            dp[index][transaction] = Math.max(buy, cooldown);    
        } else {
            int sell = helper(index + 2, tBuy, prices, dp) + prices[index];
            dp[index][transaction] = Math.max(sell, cooldown);
           
        }
        return dp[index][transaction];

    }

    
        
    
}
