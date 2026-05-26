class Solution {
    
    boolean[][] visited;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        int n = word.length();
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(0, i, j, board, word, n)) {
                    return true;
                }
            }
        }
        return false;

    }
    boolean helper(int idx, int row, int col, char[][] board, String word, int n) {
        if (idx == n) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return false;
        }
        char ch = word.charAt(idx);
        if (board[row][col] != ch) {
            return false;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            
            if (helper(idx + 1, r, c, board, word, n)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;

    }
}
