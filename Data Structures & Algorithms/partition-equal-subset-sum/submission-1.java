class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum/2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[target + 1][n + 1];
        return helper(nums, target, 0, memo);
    }

    public boolean helper(int[] nums, int target, int index, Boolean[][] memo) {
        if (index >= nums.length || target < 0) {
            return false;
        }

        if (memo[target][index] != null) {
            return memo[target][index];
        }

        if (target == 0) {
            memo[target][index] = true;
            return true;
        }

        boolean res = helper(nums, target - nums[index], index + 1, memo) || helper(nums, target , index + 1, memo);
        memo[target][index] = res;
        return res;
    }
}
