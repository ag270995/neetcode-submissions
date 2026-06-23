class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int maxReach = nums[0];
        int endOfCurrentJump = nums[0];
        int jump = 1;
        int i = 1;
        while (endOfCurrentJump < n - 1 && i < n) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (i == endOfCurrentJump) {
                endOfCurrentJump = maxReach;
                jump++;
            }
            i++;
        }

        return jump;

        
    }
}