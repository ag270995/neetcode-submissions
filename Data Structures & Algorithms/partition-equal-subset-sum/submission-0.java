class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return helper(nums, sum/2, 0);
    }

    public boolean helper(int[] nums, int target, int index) {
        if (index >= nums.length) {
            return false;
        }

        if (target < 0) {
            return false;
        }

        if (target == 0) {
            return true;
        }

       return  helper(nums, target - nums[index], index + 1) || helper(nums, target , index + 1);



        
        
    }
}
