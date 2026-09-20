class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int res = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
