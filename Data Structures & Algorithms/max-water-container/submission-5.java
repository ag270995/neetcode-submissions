class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l <= r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            res = Math.max(res, area);
//             The height is limited by the shorter line, so to potentially increase the area, we must move the pointer at the shorter line inward.
// Moving the taller line never helps because it keeps the height the same but reduces the width.
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
