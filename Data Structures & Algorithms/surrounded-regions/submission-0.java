class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    visited[i][j] = true;
                }
            }
        }
        List<List<int[]>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    List<int[]> list = new ArrayList<>();
                    dfs(board, visited, list, i, j);
                    res.add(list);
                }
            }
        }

        for (List<int[]> list : res) {
            traverse(list, board);
        }
    }

    void traverse(List<int[]> list, char[][] board) {
        boolean flag = true;
        int rows = board.length;
        int cols = board[0].length;

        for (int[] pos : list) {
            int r = pos[0];
            int c = pos[1];
            if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                flag = false;
                break;
            }
        }

        if (flag) {
            for (int[] pos : list) {
                int r = pos[0];
                int c = pos[1];
                board[r][c] = 'X';
            }
        }
    }

    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    void dfs(char[][] board, boolean[][] visited, List<int[]> list, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        list.add(new int[] {row, col});

        for (int[] d : dirs) {
            int r = row + d[0];
            int c = col + d[1];
            dfs(board, visited, list, r, c);
        }
    }
}
