class Solution {
    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int sum, int i) {
        if (memo.containsKey(i) &&  memo.get(i).containsKey(sum)) {
            memo.get(i).get(sum);
        }
        int n = nums.length;
        
        if (i == n) {
            if (sum == target) {
                return 1;
            } 
            return 0;
        }
        int res =  dfs(nums, target, sum + nums[i], i + 1) 
                + dfs(nums, target, sum - nums[i], i + 1);
        if (!memo.containsKey(i)) {
            memo.put(i, new HashMap<>());
        }
        memo.get(i).put(sum, res);
        
        return res;
        
    }
}