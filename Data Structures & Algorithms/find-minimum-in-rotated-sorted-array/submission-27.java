class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        while (l <= r) {
            int m = l + (r - l)/2;
            res = Math.min(res, nums[m]);
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
