class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        PriorityQueue<Integer> ts = new PriorityQueue<Integer>((a,b) -> b - a);
        int l = 0;
        for (int r = 0; r < n; r++) {
            ts.add(nums[r]);
            if (ts.size() > k) {
                ts.remove(nums[l++]);
            }
            if (ts.size() == k) {
                res[index++] = ts.peek();
            }


        }
        return res;
    }
}
