public class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] memo = new Integer[amount + 1][coins.length + 1];

        int result = solve(amount, coins.length, coins, memo);

        return result == max ? -1 : result;
    }

    int max = (int)1e9;

    private int solve(int amount, int n, int[] coins, Integer[][] memo) {
        if (amount == 0) {
            return 0;
        }

        if (n == 0) {
            return max;
        }

        if (memo[amount][n] != null) {
            return memo[amount][n];
        }

        // Don't take current coin
        int notTake = solve(amount, n - 1 , coins, memo);

        // Take current coin
        int take = max;

        if (coins[n - 1] <= amount) {
            take = 1 + solve(amount - coins[n - 1], n, coins, memo);
        }

        memo[amount][n] = Math.min(take, notTake);

        return memo[amount][n];
    }
}