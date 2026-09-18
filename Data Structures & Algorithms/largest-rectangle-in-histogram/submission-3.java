class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = heights.length;
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int currHeight = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                int height = heights[stack.pop()];
                int right = i - 1;
                int left;
                if (stack.isEmpty()) {
                    left = 0;
                } else {
                    left = stack.peek() + 1;
                }
                int width = right - left + 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}
