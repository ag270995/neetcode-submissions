class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int sum, int i) {
        int n = nums.length;
        
        if (i == n) {
            if (sum == target) {
                return 1;
            } 
            return 0;
        }
         
        return dfs(nums, target, sum + nums[i], i + 1) + dfs(nums, target, sum - nums[i], i + 1);
        
    }
}
