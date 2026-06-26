class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = intervals[i - 1];
            int[] curr = intervals[i];
            if (prev[1] > curr[0]) {
                curr[1] = Math.min(curr[1], prev[1]);
                res++;
            }

        }

        return res;
    }
}
