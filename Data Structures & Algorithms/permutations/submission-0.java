class Solution {
    Set<Integer> set = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new ArrayList<>());
        return res;
    }

    public void permute(int[] nums, List<Integer> curr) {
        int n = nums.length;
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            curr.add(nums[i]);
            permute(nums, curr);
            set.remove(nums[i]);
            curr.removeLast();
        }
    }


}
