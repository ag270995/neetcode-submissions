class Solution {
    public boolean canFinish(int numCourses, int[][] preq) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for (int[] arr : preq) {
            graph.get(arr[1]).add(arr[0]);
            indegree.put(arr[0], indegree.get(arr[0]) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        int finished = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> neighbours = graph.get(course);
            finished++;
            for (Integer neighbour : neighbours) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if (indegree.get(neighbour) == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return numCourses == finished;
    }
}
