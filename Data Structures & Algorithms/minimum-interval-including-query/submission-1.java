class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int i = 0;
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        for(int query : queries) {
            int dis = Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {
                int[] interval = intervals[j];
                int start = interval[0];
                int end = interval[1];
                if (query >= start && query <= end && dis > end - start + 1) {
                    dis = end - start + 1;
                    res[i] = dis;
                }
            }
            i++;
        }
        return res;
        
    }
}
