class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            max.offer(stone);
        }

        while (max.size() >= 2) {
            int first = max.poll();
            int second = max.poll();
            if (first != second) {
                max.offer(first - second);
            }
            
        }
        if (max.isEmpty()) {
            return 0;
        }
        return max.peek();
    }
}
