class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board[0].length;
        Set<Character> setRow = new HashSet<>(n);
        Set<Character> setColumn = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            setRow.clear();
            setColumn.clear();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (setRow.contains(board[i][j])) {
                        return false;
                    }
                    setRow.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (setColumn.contains(board[j][i])) {
                        return false;
                    }
                    setColumn.add(board[j][i]);
                }
            }  
        }
        Set<Character> setMat = new HashSet<>(n);
        for (int square = 0; square < n; square++) {
            setMat.clear();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] != '.') {
                        if (setMat.contains(board[row][col])) {
                            return false;
                        }
                        setMat.add(board[row][col]); 
                    }

                }
            }
              
            
        }
        return true;
    }

    

    
}
