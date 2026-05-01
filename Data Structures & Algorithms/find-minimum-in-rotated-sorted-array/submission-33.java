class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        while (l <= r) {
            int mid = l + (r - l)/2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
