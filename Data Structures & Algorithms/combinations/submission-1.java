class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public void combine(int i, int n, int k, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i > n) {
            return;
        }

        for (int j = i; j <= n; j++) {
            curr.add(j);
            combine(j + 1, n, k, curr, res);
            curr.remove((int)curr.size() - 1);

        }
    }
}