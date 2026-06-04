class Solution {
    public int[] findOrder(int numCourses, int[][] preq) {
        int[] in = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : preq) {
            int course = pre[1];
            int next = pre[0];
            in[next]++;
            graph.get(course).add(next);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[i++] = course;
            for (int next : graph.get(course)) {
                in[next]--;
                if (in[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return i == numCourses ? res: new int[0]; 
    }
}
