class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int currMin = 1;
        int currMax = 1;
        for (int num : nums) {
            int temp = num * currMax;
            currMax = Math.max(num, Math.max(temp, num * currMin));
            currMin = Math.min(num, Math.min(temp, num * currMin));
            res = Math.max(res, currMax);
        }
        return res;
    }
}
