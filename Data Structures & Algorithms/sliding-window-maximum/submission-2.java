class Solution {
    // we just need to maintain a fixed window of K
    // as we move the window and we need to add or remove
    // element from max heap in each iteration 
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int l = 0;
        int len = nums.length - k + 1;
        int[] arr = new int[len];
        int i = 0;
        for (int r = 0; r < nums.length; r++) {
            pq.offer(nums[r]);
            if (r - l + 1 > k) {
                pq.remove(nums[l]);
                l++;
            } 
            if (r - l + 1 == k) {
                arr[i++] = pq.peek();
            }
        }
        return arr;
        
    }
}
