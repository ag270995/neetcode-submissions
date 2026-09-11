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

        Set<Character> visited = new HashSet<>(n);
        for (int i = 0; i < n; i += 3) {
            int rowStart = i;
            int rowEnd = i + 2;

            for (int j = 0; j < n; j += 3) {
                
                int colStart = j;
                int colEnd = j + 2;
                if (isVisited(visited, rowStart, rowEnd, colStart, colEnd, board)) {
                    return false;
                }
            }

        } 
        return true;
    }

    boolean isVisited(Set<Character> visited, int rowStart, int rowEnd, int colStart, int colEnd, char[][] board) {
        visited.clear();
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (board[i][j] != '.') {
                    if (visited.contains(board[i][j])) {
                        return true;
                    }
                    visited.add(board[i][j]);
                }
            }  
        }
        return false; 
    }

    

}
    

