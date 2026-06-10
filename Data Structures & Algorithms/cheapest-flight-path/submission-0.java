class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int sc = flight[0];
            int des = flight[1];
            int cost = flight[2];
            graph.get(sc).add(new int[]{cost, des});
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int cost = node[0];
            int ap = node[1];
            if (ap == dst) {
                return cost;
            }
            int stops = node[2];
            visited[ap] = true;
            for (int[] child : graph.get(ap)) {
                int d = child[1];
                int c = child[0];
                int ns = stops;
                if (d != dst) {
                    ns++;
                }
                if (!visited[d] && ns <= k) {
                     pq.offer(new int[]{cost + c, d, ns});
                }
            }

        }

        return -1;
    }
}
