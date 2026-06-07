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

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        while (!queue.isEmpty()) {
            double[] node = queue.poll();           
            double prob = node[0];
            int start = (int) node[1];      
            if (end_node == start) {
                return prob;
            }
            if (maxProb[start] > prob) {
                continue;
            }

            for (double[] edge : graph.get(start)) {
                double p = prob * edge[0];
                double e = edge[1];
                if (p > maxProb[(int)e]) {
                    maxProb[(int)e] = p;
                    queue.offer(new double[]{p, e});
                }

                

            }
        }

        return 0;
    }
}