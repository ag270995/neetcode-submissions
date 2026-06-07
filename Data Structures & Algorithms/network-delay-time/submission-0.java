class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : times) {
            int s = edge[0];
            int d = edge[1];
            int t = edge[2];
            graph.get(s).add(new int[]{t, d});
        }
        int timeToCover = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, k});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int time = arr[0];
            int node = arr[1];
            if (map.containsKey(node)) {
                continue;
            }
            timeToCover = Math.max(timeToCover, time);
            map.put(node, time);
            for (int[] edge : graph.get(node)) {
                queue.offer(new int[]{edge[0] + time, edge[1]});
            }
            
        }
        return map.size() == n ? timeToCover : -1;
        
    }
}
