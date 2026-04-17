class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int index = 1; index < nums.length; index++) {
            int diff = target - nums[index];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), index};
            }
            map.put(nums[index], index);
        }
        return new int[]{};
    }
}
