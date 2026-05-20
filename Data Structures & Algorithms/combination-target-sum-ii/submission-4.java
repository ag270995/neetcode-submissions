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
        curr.add(arr[i]);
        sum += arr[i];
        helper(arr, i + 1, sum, curr, target);
        while (i + 1 < n && arr[i] == arr[i + 1]) {
            i++;
        }
        curr.removeLast();
        sum -= arr[i];
        helper(arr, i + 1, sum, curr, target);

    }
}
