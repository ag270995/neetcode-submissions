class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[amount + 1][coins.length];
        return change(0, amount, coins, memo);
    }

    public int change(int start, int amount, int[] coins, Integer[][] memo) {
        int n = coins.length;
        if (start >= n || amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (memo[amount][start] !=  null) {
            return memo[amount][start];
        }
        int res = 0;
        for (int i = start; i < n; i++) {
            res += change(i, amount - coins[i], coins, memo); 
        }
        memo[amount][start] = res;
        return res;
    }
}
