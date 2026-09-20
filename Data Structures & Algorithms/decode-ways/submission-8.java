class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(s.length(), 1);
        return numDecodings(s, 0, map);
        
    }


    public int numDecodings(String s, int i, Map<Integer, Integer> map) {
        int n = s.length();
        if (map.containsKey(i)) {
            return map.get(i);
        }
        if (s.charAt(i) == '0') {
            map.put(i, 0);
            return 0;
        }
        int res = numDecodings(s, i + 1, map);
        if (i + 1 < n 
            && ((s.charAt(i) == '1') || (s.charAt(i) == '2' &&  s.charAt(i + 1) < '7'))) {
                res += numDecodings(s, i + 2, map);
        }
        map.put(i, res);
        return res;
    }
}
