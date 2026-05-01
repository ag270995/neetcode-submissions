class Solution {
    //[7,1,2,3,4,5,6]
    //
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];
        while (l <= r) {
            int m = l + (r - l)/2;
            res = Math.min(res, nums[m]);
            if (nums[m] < nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            } 
        }
        return res;
        
    }
}
