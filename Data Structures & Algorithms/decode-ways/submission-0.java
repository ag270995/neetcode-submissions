class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n + 1];
        dp[n] = 1;

        return numDecodings(s, 0, dp);
    }

    public int numDecodings(String s, int i, Integer[] dp) {
        if (dp[i] != null) {
            return dp[i];
        }

        if (s.charAt(i) == '0') {
            dp[i] = 0;
            return 0;
        }        
        
        int res = numDecodings(s, i + 1, dp);
        if (i + 1 < s.length()) {
            if ((s.charAt(i) == '1') || 
                (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    res += numDecodings(s, i + 2, dp);
            }

        }
        dp[i] = res;
        return res;
    }
}
