class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>());
        return res;
    }
    public void subsetsWithDup(int[] nums, int i, List<Integer> currSet) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(currSet));
            return;
        }
        currSet.add(nums[i]);
        subsetsWithDup(nums, i + 1, currSet);
        currSet.remove(currSet.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        subsetsWithDup(nums, i + 1, currSet);
    }

}
