class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = newNums[nums.length  + 1] = 1; 
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(newNums, 1, nums.length, dp);
    

    }

    public int helper(int[] nums, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        dp[l][r] = 0;
        for (int i = l; i <= r; i++) {
            int curr = nums[l - 1] * nums[i] * nums[r + 1];
            int left = helper(nums, l, i - 1, dp);
            int right = helper(nums, i + 1, r, dp);
            dp[l][r] = Math.max(dp[l][r], curr + left + right);
        }
        return dp[l][r];
    }
}
