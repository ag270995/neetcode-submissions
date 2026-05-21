class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(0, i, j, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(int index, int row, int col, char[][] board, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        for (int[] d : dir) {
            int r = row + d[0];
            int c = col + d[1];

            if (helper(index + 1, r, c, board, word, visited)) {
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }
}