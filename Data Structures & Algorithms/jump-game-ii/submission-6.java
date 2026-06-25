class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int currReach = 0;
        int n = nums.length;
        int jump = 0;
        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (currReach == i) {
                currReach = maxReach;
                jump++;
            }
        }
        return jump;
    }
}
