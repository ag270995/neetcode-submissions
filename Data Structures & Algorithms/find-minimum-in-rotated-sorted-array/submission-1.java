class Solution {
    //[7,1,2,3,4,5,6]
    //
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        while (l <= r) {
            int m = l + (r - l)/2;
            if (m <= n && nums[m] > nums[m + 1]) {
               return nums[m + 1];
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m;
            } 
        }
        return -1;
        
    }
}
