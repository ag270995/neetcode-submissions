//[0,2,0,3,1,0,1,3,2,1]
//[0,2,2,3,3,3,3,3,3,3] - l
//[3,3,3,3,3,3,3,3,2,1] - r
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        
        int[] l = new int[n];
        l[0] = height[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i - 1], height[i]);
        }

        int[] r = new int[n];
        r[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += (Math.min(r[i], l[i]) - height[i]);
        }

        return res;
    }
}
