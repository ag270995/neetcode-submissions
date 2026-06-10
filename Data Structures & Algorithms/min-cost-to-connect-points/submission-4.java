class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] a = points[i];
            map.putIfAbsent(i, new ArrayList<>());
            for (int j = i + 1; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                map.putIfAbsent(j, new ArrayList<>());
                int[] b = points[j];
                int dis = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
            
                map.get(i).add(new int[]{dis, j});
                map.get(j).add(new int[]{dis, i});
                
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] point : map.get(0)) {
            queue.offer(new int[]{point[0], point[1]});
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int p1 = node[1];
            int d1 = node[0];
            if (visited.contains(p1)) {
                continue;
            }
            sum += d1;
            visited.add(p1);
            for (int[] point : map.get(p1)) {
                int p2 = point[1];
                int d2 = point[0];
                if (!visited.contains(p2)) {
                    queue.offer(new int[]{d2, p2});
                }
            }
        }
        return sum;
        
    }
}
