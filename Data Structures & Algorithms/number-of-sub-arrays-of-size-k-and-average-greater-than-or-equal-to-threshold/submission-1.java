class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0;
        int sum = 0;
        int n = arr.length;
        int count = 0;
        for (int r = 0; r < n; r++) {
            if (r - l + 1 > k) {
                sum -= arr[l];
                l++;
            }
            sum += arr[r];
            if (r - l + 1 == k) {
                if ((sum/k) >= threshold) {
                    count++;
                }
            }

        } 
        return count;
    }
}