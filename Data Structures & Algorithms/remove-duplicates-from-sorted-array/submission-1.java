class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1;
        int n = nums.length;
        for (int r = 1; r < n; r++) {
            if (nums[r - 1] != nums[r]) {
                nums[l] = nums[r];
                l++;
            } 
        }
        return l;
    }
}