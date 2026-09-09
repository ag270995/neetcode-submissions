class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        int left = 1;
        for (int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * left;
            left = left * nums[i - 1];
        }
        int right = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        

        return res;
    }
}  
