class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] pointi = points[i];
            map.putIfAbsent(i,  new ArrayList<>());
            for (int j = i + 1; j < n; j++) {
                int[] pointj = points[j];
                int dis = Math.abs(pointi[0] - pointj[0]) + Math.abs(pointi[1] - pointj[1]);
                map.putIfAbsent(j,  new ArrayList<>());
                map.get(i).add(new int[]{j, dis});
                map.get(j).add(new int[]{i, dis});
            }
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{0, 0});
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (visited.contains(node[0])) continue;
            sum += node[1];
            visited.add(node[0]);

            for (int[] child : map.get(node[0])) {
                int point = child[0];
                if (!visited.contains(point)) {
                    queue.offer(child);
                }
            }

        }

        return sum;


        

    }
}
