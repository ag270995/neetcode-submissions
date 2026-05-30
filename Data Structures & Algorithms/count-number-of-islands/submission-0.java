class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        for (int[] dir : dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            dfs(grid, i, j);
        }
        
    }
}
 