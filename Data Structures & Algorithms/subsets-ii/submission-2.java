class Solution {
    
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0);
        return res;
    }

    public void helper(int[] nums, int i) {
        res.add(new ArrayList<>(curr));   
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            curr.add(nums[j]);
            helper(nums, j + 1);
            curr.remove(curr.size() - 1);
        }
        
        
    }
}
