class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int s = grid[0][0];
        int d = grid[rows - 1][cols - 1];
        int res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] {s, 0, 0});
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Integer> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int time = node[0];
            res = Math.max(res, time);
            if (time == d) {
                break;
            }
            int row = node[1];
            int col = node[2];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r >= rows || c < 0 || c >= cols || visited.contains(grid[r][c])) {
                    continue;
                }
                visited.add(grid[r][c]);
                queue.offer(new int[]{grid[r][c], r, c});
            }
        }
        return res;
    }
}
