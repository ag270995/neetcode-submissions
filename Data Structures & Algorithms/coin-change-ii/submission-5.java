class Solution {
    //recurssive memoisation
    //choose current count => change(i, amount - coins[i], coins, memo)
    //or skip current coint => change(i + 1, amount, coins, memo)
    //sum of two is total number of combination
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[amount + 1][coins.length + 1];
        int n = coins.length;
        return change(n, amount, coins, memo);
    }

    public int change(int j, int amount, int[] coins, Integer[][] memo) {
        if (j <= 0 || amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (memo[amount][j] !=  null) {
            return memo[amount][j];
        }
        int res = change(j - 1, amount, coins, memo) + change(j, amount - coins[j - 1], coins, memo); 
        memo[amount][j] = res;
        return res;
    }

}
