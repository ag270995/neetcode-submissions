class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(':').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        int i = 0;
        List<String> res = new ArrayList<>();
         while (i < n) {
           int j = i;
           StringBuilder lenSb = new StringBuilder();
           while (str.charAt(j) != ':') {
                lenSb.append(str.charAt(j));
                j++;
           }
           int len = Integer.parseInt(lenSb.toString());
           int start = j + 1;
           int end = start + len;
           res.add(str.substring(start, end));
           i = end; 
        }
        return res;
    }

      
}
