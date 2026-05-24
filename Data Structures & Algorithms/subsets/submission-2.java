class Solution {
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, nums.length);
        return res;
    }

    public void subsets(int[] nums, int i, int n) {
        res.add(new ArrayList<>(curr));
        for (int j = i; j < n; j++) {
            curr.add(nums[j]);            
            subsets(nums, j + 1, n);
            curr.remove(curr.size() - 1);
        }
        
    }
}
