class MedianFinder {
    PriorityQueue<Integer> first;
    PriorityQueue<Integer> second;
    int size;
    public MedianFinder() {
        size = 0;
        first = new PriorityQueue<>((a, b) -> b - a);
        second = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        if (size % 2 == 0) {
            first.offer(num);
        } else {
            second.offer(num);
        }
        size++;
        if (!first.isEmpty() && !second.isEmpty() && first.peek() > second.peek()) {
            int low = second.poll();
            int high = first.poll();
            first.offer(low);
            second.offer(high);
        }

        
    }
    
    public double findMedian() {
        double res = first.peek();
        if (size % 2 == 0) {
            res = (res + (double)second.peek())/2; 
        }
        return res;
    }
}
