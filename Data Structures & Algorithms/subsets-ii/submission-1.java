class Solution {
    
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0);
        return res;
    }

    public void helper(int[] nums, int i) {
        int n = nums.length;
        if (i == n) {
            res.add(new ArrayList<>(curr));
            return;
        }    
        curr.add(nums[i]);
        helper(nums, i + 1);
        curr.remove(curr.size() - 1);
        while (i + 1 != n && nums[i] == nums[i + 1]) {
            i++;
        }
        helper(nums, i + 1);
    }
}
