class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        for (int i = 0; i < s.length(); i++) {
            String s1 = getPallindrom(s, i, i);//odd
            String s2 = getPallindrom(s, i, i + 1);//even
            String temp = s1.length() > s2.length() ? s1 : s2;
            if (temp.length() > resLen) {
                res = temp;
                resLen = temp.length();
            }
        }
        return res;
    }


    String getPallindrom(String s, int start, int end) {
        int len = 0;
        String res = "";
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if (end - start + 1 > len) {
                len = end - start + 1;
                res = s.substring(start, end + 1);
            }
            start--;
            end++;
        }
        return res;
    }
}
