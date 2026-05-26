class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(0, board, n);
        return res;
    }

    void helper(int col, char[][] board, int n) {
        if (col >= n) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            res.add(list);
        }
        for (int row = 0; row < n; row++) {
            if (check(board, row, col)) {
                board[row][col] = 'Q';
                helper(col + 1, board, n);
                board[row][col] = '.';
            }
            
        }
    }

    boolean check(char[][] board, int row, int col) {

        //check element in row = row till col -> 0 to col -1
        for (int c = 0; c < col; c++) {
            if (board[row][c] == 'Q') {
                return false;
            }
        }
        // check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check lower left diagonal
        for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }



    

}
