class Solution {
    Set<Integer> set = new HashSet<>();
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums);
        return res;
    }

    public void helper(int[] nums) {
        int n = nums.length;
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            curr.add(nums[i]);
            helper(nums);
            set.remove(i);
            curr.remove(curr.size() - 1);
        }
    }
}
