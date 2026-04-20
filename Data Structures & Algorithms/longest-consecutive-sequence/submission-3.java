class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            //if it does not have previous consecutive number, then it cab be a starting point 
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }

    int longestConsecutiveHelper(int num, Map<Integer, Integer> map) {
        if (map.get(num) != -1) {
            return map.get(num);
        }
        int count = 1;
        if (map.containsKey(num - 1)) {
            count = 1 +  longestConsecutiveHelper(num - 1, map);
        }
        map.put(num, count);
        return count;
    }


}
