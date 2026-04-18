class Solution {

    //[1,2,4,6]
    //[1,2,8,48]
    //[48,48,24,6]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums;
        }
        
        int[] left = new int[n];
        left[0] = nums[0];
        
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
            right[n - i - 1] =  right[n - i] * nums[n - i - 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = right[i + 1];
            } else if (i == n - 1) {
                res[i] = left[i - 1];
            } else {
                res[i] = left[i - 1] * right[i + 1];
            }   
        }
        return res;
    }
}  
