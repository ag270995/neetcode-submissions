class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, -1);
        }
        int max = 0;
        for (int num : nums) {
            if (map.get(num) == -1) {
                max = Math.max(max, longestConsecutiveHelper(num, map));
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
