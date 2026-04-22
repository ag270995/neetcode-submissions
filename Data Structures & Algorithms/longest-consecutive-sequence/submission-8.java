class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (Integer num : nums) {
            set.add(num);        
        }
        int max = 1;
        for (int num : set) {
            int length = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + length)) {
                    length++;
                }
            }
            max = Math.max(max, length);
        }
        return max;
        
    }
}
