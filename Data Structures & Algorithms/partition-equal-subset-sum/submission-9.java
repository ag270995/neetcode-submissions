class Solution {
    //refer solution 1 for recurrsive solution
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int n = nums.length;
        int target = sum/2;
        Boolean[][] memo = new Boolean[target + 1][n];
        return helper(nums, memo, 0, target);
    }

    boolean helper(int[] nums, Boolean[][] memo, int index, int target) {
        int n = nums.length;
        if (index >= n || target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (memo[target][index] != null) {
            return memo[target][index];
        }
        boolean res = helper(nums, memo, index + 1, target - nums[index]) 
            || helper(nums, memo, index + 1, target);
        memo[target][index] = res;
        return res;
    }
}
