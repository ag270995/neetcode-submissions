class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] p = new boolean[rows][cols];
        boolean[][] a = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(0, c, p, heights);
            dfs(rows - 1, c, a, heights);
        }

        for (int r = 0; r < rows; r++) {
            dfs(r, 0, p, heights);
            dfs(r, cols - 1, a, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] && p[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }


    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void dfs(int r, int c, boolean[][] ocean, int[][] h) {
        int rows = h.length;
        int cols = h[0].length;
        ocean[r][c] = true;
        for (int[] d : dirs) {
            int i = r + d[0];
            int j = c + d[1];
            if (i < 0 || i >= rows || j < 0 || j >= cols || h[i][j] < h[r][c] || ocean[i][j]) {
                continue;
            }
            dfs(i, j, ocean, h);
        }
    }
}
