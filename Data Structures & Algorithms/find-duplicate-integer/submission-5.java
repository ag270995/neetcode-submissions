class Solution {
    public int findDuplicate(int[] nums) {
        int n = 10001;
        int[] freq = new int[n];
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > 1) {
                return num;
            }
        }
        return -1;
    }

    
}
