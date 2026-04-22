class Solution {
    //[-1,0,1,2,-1,-4,-2,-3,3,0,4]
    //[-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int index = 0; 
        int n = nums.length;
        while (index <= n - 3) {
            if (index != 0 && nums[index] == nums[index - 1]) {
                index++;
                continue;
            } else {
                list.addAll(check(index, nums));
                index++;
            }
        }
        return list;
    }

    public List<List<Integer>> check(int index, int[] nums) {
        int n = nums.length;
        int target = nums[index];
        int start = index + 1;
        int end = n - 1;
        List<List<Integer>> list = new ArrayList<>();
        while (start < end) {
            if (-1*target == (nums[start] + nums[end]) ) {
                list.add(Arrays.asList(target, nums[start], nums[end]));
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (-1 * target > (nums[start] + nums[end])) {
                start++;
            } else {
                end--;
            }
        }
        return list;
    } 
}