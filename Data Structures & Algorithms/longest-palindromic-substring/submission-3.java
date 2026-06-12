class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0;
        int resIdx = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            //odd palindrom have only 1 centre, that's why both l, r = i
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resIdx = l;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
            //even palindrom have 2 centres, that's why both l = i, r = i + 1
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resIdx = l;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
             
        }
        return s.substring(resIdx, resLen + resIdx);
    }
}
