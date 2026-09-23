class Solution {
    Integer[][] memo;
    int totalSum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            totalSum += num;
        }

        // The current sum can range from -totalSum to +totalSum.
        // Therefore, the number of possible sums is:
        // +totalSum - (-totalSum) + 1 = 2 * totalSum + 1.
        //
        // We use totalSum as an offset to convert negative sums
        // into valid array indices:
        //   sum = -totalSum -> index 0
        //   sum = 0         -> index totalSum
        //   sum = +totalSum -> index 2 * totalSum
        //
        // memo[sum + totalSum][i] stores the number of ways to
        // reach 'target' using elements from index i onward,
        // given that the current sum is 'sum'.
        memo = new Integer[(2 * totalSum) + 1][nums.length + 1];

        return findTargetSumWays(nums, target, 0, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int i, int sum) {
        // All numbers have been processed.
        // A valid way exists if the current sum equals target.
        if (i == nums.length) {
            return target == sum ? 1 : 0;
        }

        int sumIdx = totalSum + sum;

        if (memo[sumIdx][i] != null) {
            return memo[sumIdx][i];
        }

        // For the current number, we have two choices:
        // 1. Assign '-' -> sum - nums[i]
        // 2. Assign '+' -> sum + nums[i]
        memo[sumIdx][i] = findTargetSumWays(nums, target, i + 1, sum - nums[i])
            + findTargetSumWays(nums, target, i + 1, sum + nums[i]);

        return memo[sumIdx][i];
    }
}