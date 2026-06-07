class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double p = succProb[i];
            graph.get(edge[0]).add(new double[]{p, edge[1]});
            graph.get(edge[1]).add(new double[]{p, edge[0]});
        }
        
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        queue.offer(new double[]{1.0, start_node});

        boolean[] visited = new boolean[n];

        while (!queue.isEmpty()) {
            double[] node = queue.poll();           
            double prob = node[0];
            int start = (int) node[1];      
            if (end_node == start) {
                return prob;
            }
            if (visited[start]) {
                continue;
            }
            visited[start] = true;
            for (double[] edge : graph.get(start)) {
                double p = edge[0];
                double e = edge[1];
                queue.offer(new double[]{p*prob, e});

            }
        }

        return 0;
    }
}