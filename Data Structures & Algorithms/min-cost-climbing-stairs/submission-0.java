class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int first = cost[0];
       int second = cost[1];
       int n = cost.length;
       for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
       }

       return Math.min(first, second); 
    }
}
