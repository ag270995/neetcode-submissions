class Solution {
    public boolean canFinish(int numCourses, int[][] preq) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] arr : preq) {
            graph.get(arr[1]).add(arr[0]);
            indegree[arr[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int finished = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finished++;
            for (Integer next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return numCourses == finished;
    }
}
