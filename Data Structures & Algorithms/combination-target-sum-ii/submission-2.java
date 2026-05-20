class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, 0, new ArrayList<>(), target);
        return res;
    }

    public void helper(int[] arr, int i, int sum, List<Integer> curr, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        int n = arr.length;
        if (sum > target || i >= n) {
            return;
        }
        for (int j = i; j < n; j++) {
            if (sum + arr[j] > target) {
                break;
            }
            if (j > i && arr[j - 1] == arr[j]) {
                continue;
            }
            curr.add(arr[j]);
            
            helper(arr, j + 1, sum + arr[j], curr, target);
            curr.removeLast();  
        }

    }
}