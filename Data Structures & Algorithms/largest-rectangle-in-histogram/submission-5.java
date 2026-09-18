// Idea:
// For every bar, find how far it can extend to the left and right
// while maintaining its height, then calculate height * width.
//
// Stack stores indices of bars in increasing order of height.
// When a smaller bar comes, the current smaller bar becomes the right boundary
// for the bars that are popped, and the element remaining at the top of the stack
// becomes the left boundary.
//
// If the stack is empty after popping, there is no smaller bar on the left,
// so the left boundary is the start of the array (index 0).

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = heights.length;
        int max = 0;

        // i <= n because at i == n we use height 0 to flush the remaining stack.
        for (int i = 0; i <= n; i++) {

            // At the end, imaginary height 0 ensures all remaining bars are popped.
            int currHeight = i == n ? 0 : heights[i];

            // Current bar is smaller, so the popped bar cannot extend up to i.
            while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {

                int height = heights[stack.pop()];

                // i is the first smaller bar on the right,
                // so the last valid index is i - 1.
                int right = i - 1;

                // After popping, stack.peek() is the first smaller bar on the left,
                // so the first valid index is stack.peek() + 1.
                int left = !stack.isEmpty() ? stack.peek() + 1 : 0;

                // All bars from left to right can form a rectangle of this height.
                int width = right - left + 1;

                max = Math.max(max, height * width);
            }

            // Store index because we need both height and position later.
            stack.push(i);
        }

        return max;
    }
}