class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int index = 0;
        int start = 0;
        int sum = 0;
        int size = 0;
        while (start < n && size < n) {
            sum += gas[index] - cost[index];
            if (sum < 0) {
                sum = 0;
                start++;
                index = start;
                size = 0;
            } else {
                size++;
                index = (index + 1)%n;
            }  

        }

        if (size == n) {
            return start;
        }

        return -1; 


    }
}
