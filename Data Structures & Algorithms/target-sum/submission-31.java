class Solution {
    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    private int dfs(int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        Map<Integer, Integer> innerMap = memo.get(i);

        if (innerMap != null && innerMap.containsKey(sum)) {
            return innerMap.get(sum);
        }

        int res = dfs(nums, target, sum + nums[i], i + 1)
                + dfs(nums, target, sum - nums[i], i + 1);

        memo.computeIfAbsent(i, k -> new HashMap<>()).put(sum, res);

        return res;
    }
}