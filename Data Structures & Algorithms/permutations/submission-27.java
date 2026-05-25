class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        helper(nums, 0, n);
        return res;
    }

    void helper(int[] nums, int i, int n) {
        if (i >= n) {
            List<Integer> list = new ArrayList<>(n);
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int j = i; j < n; j++) {
            swap(nums, i, j);
            helper(nums, i + 1, n);
            swap(nums, i, j);
        }

    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
