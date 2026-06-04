class Solution {
    public boolean validTree(int n, int[][] edges) {

        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        if (!dfs(visited, graph, 0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    boolean dfs(Set<Integer> visited, List<List<Integer>> graph, int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (Integer neigh : graph.get(node)) {
            if (neigh != parent) {
                if (!dfs(visited, graph, neigh, node)) {
                    return false;
                }
            }
        }
        return true;

    }
}
