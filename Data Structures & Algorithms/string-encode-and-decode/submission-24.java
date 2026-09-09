class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < str.length()) {
            int j = i;
            StringBuilder stringLength = new StringBuilder();
            while (str.charAt(j) != '#') {
                stringLength.append(str.charAt(j));
                j++;
            }
            int size = Integer.parseInt(stringLength.toString());
            int start = j + 1;
            int end = start + size;
            res.add(str.substring(start, end));
            i = end;
        }
        return res;
    }
}
