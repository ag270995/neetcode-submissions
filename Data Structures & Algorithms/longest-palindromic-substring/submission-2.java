class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0;
        int resLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] s1 = getPallindrom(s, i, i);//odd
            int[] s2 = getPallindrom(s, i, i + 1);//even
            int[] r = s1[1] > s2[1] ? s1 : s2;
            if (r[1] > resLen) {
                resIdx = r[0];
                resLen = r[1];
            }
            
        }
        return s.substring(resIdx, resIdx + resLen);
    }


    int[] getPallindrom(String s, int start, int end) {
        int len = 0;
        int resIdx = start;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if (end - start + 1 > len) {
                len = end - start + 1;
                resIdx = start;
            }
            start--;
            end++;
        }
        return new int[]{resIdx, len};
    }
}
