class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n) {
            if (res.isEmpty()) {
                res.add(intervals[i]);
                i++;
            } else {
                int[] prev = res.get(res.size() - 1);
                if (prev[1] >= intervals[i][0]) {
                    prev[0] = Math.min(prev[0], intervals[i][0]);
                    prev[1] = Math.max(prev[1], intervals[i][1]);
                    i++;
                } else {
                    res.add(intervals[i]);
                    i++;
                }
            }
        }


        return res.toArray(new int[res.size()][]);
        
    }
}
