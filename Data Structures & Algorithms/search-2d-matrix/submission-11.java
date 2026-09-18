class Solution {
    // typical binary search problem in 2D array (m*n)
    // idea is to treat 2D array is 1D array with size = (m * n)
    // so left = 0, first index
    // and right = m*n - 1, last index
    // mid = (left + right)/2
    // Now interestingly how to locate the mid in 2D array
    // think like a row have total n values because n columns so for given "mid", row = (mid/n);
    // and for col, consider it as position of mid in a row, so col = mid%n
    //then standard BST algo

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = (rows * cols) -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int row = mid / cols;
            int col = mid % cols;
            int result = matrix[row][col];
            if (result < target) {
                left = mid + 1;
            } else if (result > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;

    }
}
