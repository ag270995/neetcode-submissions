class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int count = 1;
        double prevTime = (double)(target - arr[0][0])/arr[0][1];
        for (int i = 1; i < n; i++) {
            double time = (double)(target - arr[i][0])/arr[i][1];
            if (time > prevTime) {
                count++;
                prevTime = time;
            }
        }
        return count;
    }

}
