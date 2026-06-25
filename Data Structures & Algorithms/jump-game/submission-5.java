class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length - 1 && maxReach >= i; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                break;
            }
        }
        return maxReach >= nums.length - 1 ;
    }
}
