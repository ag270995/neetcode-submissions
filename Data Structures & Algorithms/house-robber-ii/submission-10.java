// it's the variation of house roober problem, with one twist that in this case, array is curcular 
// hence first and last can be considered neighbours, which means we cannot use constributions of first index in last and vice-versa
// so while inculding last index don't use i = 0, for calculating i = 0 don't use i = n - 1
// maximum of rob(nums, 0, n - 2), rob(nums, 1, n - 1))
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }


    public int rob(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }


}
