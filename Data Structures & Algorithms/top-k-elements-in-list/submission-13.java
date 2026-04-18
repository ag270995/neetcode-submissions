class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] arr = new List[nums.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }
        
        int[] res = new int[k];
        int index = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            List<Integer> list = arr[i];
            for (int element : list) {
                res[index++] = element;
                if (index == k) {
                    return res;
                } 
            }
        }
        return res; 
    }
}
