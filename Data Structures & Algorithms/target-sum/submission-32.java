class Solution {
    Integer[][] memo;
    int totalSum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            totalSum += num;
        }
        // based on question - the amount calculated from -sum(all the negative numbers) to +sum(all
        // positive numbers)
        // total size = sum -(-sum) + 1 = 2*sum + 1
        memo = new Integer[(2 * totalSum) + 1][nums.length + 1];
        return findTargetSumWays(nums, target, 0, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            return target == sum ? 1 : 0;
        }

        int sumIdx = totalSum + sum;

        if (memo[sumIdx][i] != null) {
            return memo[sumIdx][i];
        }

        memo[sumIdx][i] = findTargetSumWays(nums, target, i + 1, sum - nums[i])
            + findTargetSumWays(nums, target, i + 1, sum + nums[i]);

        return memo[sumIdx][i];
    }
}