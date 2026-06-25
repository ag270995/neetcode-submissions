class Solution {
    public List<Integer> partitionLabels(String s) {
        int len = 1;
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                list.add(len);
                len = 1;
            } else {
                len++;
            }
        }
        return list;
    }
}