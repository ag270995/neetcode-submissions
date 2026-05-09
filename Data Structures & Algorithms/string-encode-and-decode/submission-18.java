class Solution {

    /*
        2#to3#thre
        0123456789

    */

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append("~").append(str.length()).append("`").append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '`') {
                int j = i - 1;
                int size = 0;
                int decimal = 1;
                while (str.charAt(j) != '~') {
                    size +=  (int)(str.charAt(j) - '0')  * decimal;
                    decimal = decimal * 10;
                    j--;
                }
                list.add(str.substring(i + 1, i + 1 + size));
            }
        }
        return list;
    }
}
