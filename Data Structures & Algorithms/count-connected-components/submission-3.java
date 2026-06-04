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
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(visited, graph, i, -1);
                count++;
            }
        }
        return count;

    }

    public void dfs(Set<Integer> visited, List<List<Integer>> graph, int node, int parent) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (Integer neighbour : graph.get(node)) {
            if (parent != neighbour) {
                dfs(visited, graph, neighbour, node);
            }
            
        }
    }
}
