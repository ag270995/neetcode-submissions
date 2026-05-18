class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums, 0, 0, target, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int i, int sum, int target, List<Integer> curr) {
        int n = nums.length;
        if (i >= n || sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        sum += nums[i];
        helper(nums, i, sum, target, curr);
        curr.remove((int) curr.size() - 1);
        sum -= nums[i];
        helper(nums, i + 1, sum, target, curr);
    }
}
