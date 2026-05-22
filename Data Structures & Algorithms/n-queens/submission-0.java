class Solution {
    List<List<String>> res = new ArrayList<>();    
    public List<List<String>> solveNQueens(int n) {
        boolean[][] arr = new boolean[n][n];  
        helper(arr, 0, n);
        return res;
    }

    void helper(boolean[][] arr, int col, int n) {
        if (col >= n) {
            res.add(print(arr, n));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (validate(arr, row, col)) {
                arr[row][col] = true;
                helper(arr, col + 1, n);
                arr[row][col] = false;
            }
        }
    }


    public List<String> print(boolean[][] arr, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (arr[i][j]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
                
            }
            list.add(sb.toString());
        }
        return list;

    }


    boolean validate(boolean[][] arr, int row, int col) {
        int n = arr.length;
        //validate row
        for (int i = 0; i < n; i++) {
            if (arr[row][i]) {
                return false;
            }
        }
        //validate column
        for (int i = 0; i < n; i++) {
            if (arr[i][col]) {
                return false;
            }
        }


        //validate daigonal upper left
        int p = row;
        int q = col;
        while (p >= 0 && q >= 0) {
            if (arr[p][q]) {
                return false;
            }
            p--;
            q--;
        }

        //validate daigonal lower right
        p = row;
        q = col;
        while (p < n && q < n) {
            if (arr[p][q]) {
                return false;
            }
            p++;
            q++;
        }


        //validate daigonal upper right
        p = row;
        q = col;
        while (p >= 0 && q < n) {
            if (arr[p][q]) {
                return false;
            }
            p--;
            q++;
        }


        //validate daigonal lower left
        p = row;
        q = col;
        while (p < n && q >= 0) {
            if (arr[p][q]) {
                return false;
            }
            p++;
            q--;
        }

        return true;

    }
}