class Solution {


    
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int dis = 0;
        int[][] dirs = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int row = pos[0] + dir[0];
                    int col = pos[1] + dir[1];
                    
                    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != INF) {
                        continue;
                    }
                    grid[row][col] = dis + 1;
                    queue.offer(new int[]{row, col});
                }
            }
            dis++;
        }
    }
}
