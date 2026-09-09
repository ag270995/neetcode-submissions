class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int res = 0;
        int l = 1;
        int r = n - 2;
        while (l <= r) {
            if (leftMax < rightMax) {
                res += Math.max(0, leftMax - height[l]);
                leftMax = Math.max(leftMax, height[l]);
                l++;
            } else {
                res += Math.max(0, rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }
        }
        return res;

    }
}
