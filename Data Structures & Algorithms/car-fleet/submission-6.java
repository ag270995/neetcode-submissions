class Solution {
    // this problem is mentioned under stack topic but honestly it more of iterative problem
    // key hints are -> car never overtakes the next car, means the car closest to target is will definitely form the first fleet
    // and to know which cars can be together with last car we have to find the time taken to reach to target from their current position starting with next closest car
    // if time taken from cars in back is greater than the next then they will be part of the same fleet otherwise, they will be counted as sepaarte fleet
    //
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        // this is sorting in descending order, otherwise it would be a[0] -b[0] for ascending order
        Arrays.sort(arr, (a1, a2) -> a2[0] - a1[0]);
        int count = 1;
        double prevTime = (double) (target - arr[0][0])/arr[0][1];
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
