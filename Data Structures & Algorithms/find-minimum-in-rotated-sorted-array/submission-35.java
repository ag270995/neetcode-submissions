class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        while (l <= r) {
            int m = l + (r - l)/2;
            if (m > 0 && nums[m - 1] > nums[m]) {
                return nums[m];
            }
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return -1;
    }
}
