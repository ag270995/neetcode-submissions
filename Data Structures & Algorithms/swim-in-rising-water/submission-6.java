class Solution {
    
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] {grid[0][0], 0, 0});
        
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        int res = 0;        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int time = node[0];
            int row = node[1];
            int col = node[2];
            res = Math.max(res, time);
            
            if (row == rows - 1 && col == cols - 1) {
                break;
            }
            
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                queue.offer(new int[]{grid[r][c], r, c});
            }
        }
        return res;
    }
}
