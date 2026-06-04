class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, graph, i);
                count++;
            }
        }
        return count;

    }

    public void dfs(boolean[] visited, List<List<Integer>> graph, int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (Integer neighbour : graph.get(node)) {
            dfs(visited, graph, neighbour);
        }
    }
}
