class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int res = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res = res + (leftMax - height[l]);
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res = res + (rightMax - height[r]);
            }

        }
        return res;

    }
}
