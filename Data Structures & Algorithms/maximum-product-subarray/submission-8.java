class Solution {
    public int maxProduct(int[] nums) {
       int currMin = 1;
       int currMax = 1;
       int max = Integer.MIN_VALUE;
       int n = nums.length;
       for (int i = 0; i < n; i++) {
        //currMax = 2
            int tempMax = currMax * nums[i];
            currMax = Math.max(Math.max(currMax * nums[i], currMin * nums[i]), nums[i]);
        //currMin 2
            currMin = Math.min(Math.min(tempMax, currMin * nums[i]), nums[i]);
            max = Math.max(currMax, max);
       }
       return max;
        
    }
}
