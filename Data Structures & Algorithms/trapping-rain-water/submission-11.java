class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int res = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            // Core idea: waterTrapped[i] = min(leftMax, rightMax) - height[i]
//
// leftMax  = maximum height from index 0 to l
// rightMax = maximum height from index n-1 to r
//
// We increment l before computing leftMax so the current left element
// is included in the leftMax calculation.
// We decrement r before computing rightMax so the current right element
// is included in the rightMax calculation.
//
// We use min(leftMax, rightMax) because the bottleneck is always the smaller boundary.
//
// If leftMax < rightMax:
//   leftMax will always be smaller than the actual rightMax at the current position,
//   so we subtract leftMax.
//
// If rightMax <= leftMax:
//   rightMax will always be smaller than the actual leftMax at the current position,
//   so we subtract rightMax.
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
                
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;

    }
}
