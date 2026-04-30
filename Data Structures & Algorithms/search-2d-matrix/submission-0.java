class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            if (search(matrix[row], target) != -1) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left >= 0 && left < n && nums[left] == target) {
            return left;
        }


        return -1;
    }


    
}
