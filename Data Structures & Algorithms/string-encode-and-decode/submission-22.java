class Solution {

public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (str.isEmpty()) {
                str = "e>m<p><><>t*y";
            }
            sb.append(str).append(">dJ<%>4><");
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        String[] strs = str.split(">dJ<%>4><");
        for (String s : strs) {
            if (s.equals("e>m<p><><>t*y")) {
                res.add("");
            } else {
                res.add(s);
            }
        }
        return res;
    }
}