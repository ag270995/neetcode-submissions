class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 1;
        int currMin = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            int tempMax = currMax * num;
            currMax = Math.max(num, Math.max(num * currMax, num * currMin));
            currMin = Math.min(num, Math.min(tempMax, num * currMin));
            res = Math.max(res, currMax);
        }
        return res;
    }
}
