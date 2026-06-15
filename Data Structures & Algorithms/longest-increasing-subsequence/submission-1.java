class Solution {
    //9 - 1
    //1 - 1
    //4 - 2
    //2 - 2
    //3 - 3
    //3 - 3
    //
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            int tempMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    tempMax = Math.max(tempMax, dp[j]);
                }
            }
            dp[i] += tempMax;
            max = Math.max(dp[i], max);
        }
        return max;
        
    }
}
