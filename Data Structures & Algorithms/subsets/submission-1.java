class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new ArrayList<>());
        return res;
    }

    public void subsets(int[] nums, int i, List<Integer> currSet) {
        int n = nums.length;
        if (i >= n) {
            res.add(new ArrayList<>(currSet));
            return;
        }
        currSet.add(nums[i]);
        subsets(nums, i + 1, currSet);
        currSet.remove(currSet.size() - 1);
        subsets(nums, i + 1, currSet);
    }
}
