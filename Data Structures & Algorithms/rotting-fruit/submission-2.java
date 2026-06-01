class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        while (!queue.isEmpty() && count > 0) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] pos =  queue.poll();
                for (int[] d : dirs) {
                    int r = pos[0] + d[0];
                    int c = pos[1] + d[1];
                    if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1) {
                        continue;
                    }
                    
                    grid[r][c] = 2;
                    count--;
                    queue.offer(new int[]{r, c});
                }
            }
            time++;

        }

        return count == 0 ? time : -1;
        
    }
}
