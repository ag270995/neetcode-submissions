class Solution {
    public boolean canFinish(int numCourses, int[][] preq) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
        }

        for (int[] arr : preq) {
            graph.computeIfAbsent(arr[1], k -> new ArrayList<>()).add(arr[0]);
            indegree.put(arr[0], indegree.get(arr[0]) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            if (indegree.get(course) == 0) {
                indegree.remove(course);
            }
            List<Integer> neighbours = graph.get(course);
            if (neighbours != null) {
                for (Integer neighbour : neighbours) {
                    indegree.put(neighbour, indegree.get(neighbour) - 1);
                    if (indegree.containsKey(neighbour) && indegree.get(neighbour) == 0) {
                        queue.offer(neighbour);
                    }
                }
            }
        }

        return numCourses == 0;
    }
}
