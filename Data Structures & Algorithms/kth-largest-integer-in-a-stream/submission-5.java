class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int size = 0;
    public KthLargest(int k, int[] nums) {
        size = k;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int num) {
        pq.add(num);
        if (pq.size() > size) {
            pq.poll();
        }
        return pq.peek();
    }
}
