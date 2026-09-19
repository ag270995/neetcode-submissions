class Solution {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index] < 0) {
                return Math.abs(num);
            }
            nums[index] = -1 * nums[index];
        }
        return -1;
    }
}
