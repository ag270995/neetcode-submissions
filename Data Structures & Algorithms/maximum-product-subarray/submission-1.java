class Solution {
    public int maxProduct(int[] nums) {
        int currMin = 1;
        int currMax = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            int temp = currMax * num;
            currMax = Math.max(Math.max(temp, currMin * num), num);
            currMin = Math.min(Math.min(temp, currMin * num), num);
            res = Math.max(res, currMax);
        }
        return res;
        
    }
}
