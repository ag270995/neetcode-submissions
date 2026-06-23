class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = nums[0];
        int i = 1;
        while (maxIndex >= i && maxIndex < n - 1 && i < n) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            i++;

        }
        return  maxIndex >= n - 1;
        
    }
}
