class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        helper(nums, target, 0);
        return res;
    }

    public void helper(int[] nums, int target, int i) {   
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        int n = nums.length;
        if (i >= n && target < 0) {
            return;
        }
        for (int j = i; j < n; j++) {
            if (target - nums[j] < 0) {
                break;
            }
            curr.add(nums[j]);
            helper(nums, target - nums[j], j);
            curr.remove(curr.size() - 1);
        }
    
    }
}
