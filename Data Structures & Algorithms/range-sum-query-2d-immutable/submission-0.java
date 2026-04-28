class NumMatrix {
    //[1,2,3,4,5]
    //[1,2,3,4,5]
    //[1,2,3,4,5]
    //[1,2,3,4,5]
    //[1,2,3,4,5]
    public int[][] arr;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length + 1;
        arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 1; j < cols; j++) {
                sum = sum + matrix[i][j - 1];
                arr[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum = sum + (arr[i][col2 + 1] - arr[i][col1]);
        }   
        return sum;  
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */