class Solution {
    public boolean isNStraightHand(int[] nums, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        for (int num : nums) {
            if (map.get(num) != 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (map.getOrDefault(i, 0) == 0) {
                        return false;
                    }
                    map.put(i, map.get(i) - 1);

                }
            }
        }
        return true;
        
    }
}
