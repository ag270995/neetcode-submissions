class Solution {

    // dp[i] = number of ways to decode the first i characters.
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {

            // Decode current digit separately.
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Decode last two digits together: 10-26.
            if (s.charAt(i - 2) == '1' ||
                (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}