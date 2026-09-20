// - one clear thing in order to reach the top, we have to know the cost of last two points
// - because we can take i + 1 and i + 2
// - we have to store the cost of reaching to point A in dp must have the cost of landing which cost denotes
// this also means dp of any point must have it's landing cost added

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1]; // why because we can land on 1 directly or via index => 0(means we have to add the cost of index => 0), ie min(cost[1], cost[0], cost[1])
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 2], dp[n - 1]);
    }
}
