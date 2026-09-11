class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                sum += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                sum += rightMax - height[r];
            }
        }
        return sum;
    }
}
