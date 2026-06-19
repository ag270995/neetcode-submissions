class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, helper(matrix, i, j, dp));
            }
        }
        return max;
    }

    int helper(int[][] matrix, int row, int col, int[][] dp) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        int max = 0;
        for (int[] d : dirs) {
            int i = row + d[0];
            int j = col + d[1];
            if (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length
                && matrix[row][col] < matrix[i][j]) {
                    max = Math.max(max,  helper(matrix, i, j, dp));
            }
        }
        dp[row][col] = 1 + max;
        return dp[row][col];
    }
}
