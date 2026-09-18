class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] <= nums[r]) { // means its sorted but not rotated so first element is the minimum
            return nums[l];
        }
        while (l <= r) {
            int m = l + (r - l)/2;
            if (m > 0 && nums[m - 1] > nums[m]) {
                return nums[m];
            }
            if (nums[m] > nums[r]) { // means m being greater than r, mean we are in between rotation, hence search in right to find start of rotation
                l = m + 1;
            } else {
                // means m being smaller than r, mean we are inside rotatted array, hence search in left to find start of rotation
                r = m - 1;
            }
        }
        return -1;
    }
}
