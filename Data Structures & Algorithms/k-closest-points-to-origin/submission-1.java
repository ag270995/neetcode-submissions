class Solution {
    class Coordinate {
        int[] point;
        double dis;
        public Coordinate(int[] point, double dis) {
            this.point = point;
            this.dis = dis;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinate> queue = new PriorityQueue<>((x, y) -> Double.compare(y.dis, x.dis));
        for (int[] point : points) {
            double dis = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            queue.offer(new Coordinate(point, dis));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().point;
        }
        return res;
    }

}
