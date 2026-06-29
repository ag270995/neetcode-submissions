class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] time : times) {
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] arr : map.get(k)) {
            queue.offer(new int[]{arr[0], arr[1]});
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(k);
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int point = node[0];
            if (visited.contains(point)) continue;
            visited.add(point);
            int dis = node[1];
            sum = Math.max(sum, dis);
            for (int[] arr : map.get(point)) {
                if (!visited.contains(arr[0])) {
                    queue.offer(new int[]{arr[0], arr[1] + dis});
                }
            }
        }

        return visited.size() == n ? sum : -1;
        
        
    }
}
