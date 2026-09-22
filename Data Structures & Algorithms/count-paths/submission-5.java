class Solution {
    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        return dfs(m - 1, n - 1);
    }

    int dfs(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (memo[m][n] != null) {
            return memo[m][n];
        }
        int res = dfs(m - 1, n) + dfs(m, n - 1);
        memo[m][n] = res;
        return res;
    }
}
