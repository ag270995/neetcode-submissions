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
                    res.add(List.of(nums[first], nums[last], nums[i]));
                    first++;
                    last--;
                    //to avoid duplicates within two sum
                    //we are doing duplicate removing only on left side
                    //of two sum not right side, because we only want unique combination
                    //removing from either side is okay
                    while (first < last && nums[first] == nums[first-1]) {
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

