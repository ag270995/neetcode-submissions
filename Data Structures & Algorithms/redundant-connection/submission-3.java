class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] degree = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nei : adj.get(node)) {
                degree[nei]--;

                if (degree[nei] == 1) {
                    queue.offer(nei);
                }
            }
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (degree[u] >=2  && degree[v] >= 2) {
                return new int[]{u, v};
            }
        }

        return new int[0];
    }
}

//check this