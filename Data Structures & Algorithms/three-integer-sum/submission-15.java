class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int first = i + 1;
            int last = n - 1;
            while (first < last) {
                int sum = nums[first] + nums[last] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[first], nums[last], nums[i]));
                    first++;
                    last--;
                    while (first < last && nums[first] == nums[first - 1]) {
                        first++;
                    }
                } else if (sum < 0) {
                        first++;
                } else {
                    last--;
                }
                
            } 
            

        }
        return res;
    }
}

