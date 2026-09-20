class Solution {

    // dp[i] = number of ways to decode the first i characters.
    //so dp[0] means empty string
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1; // number of ways to decode empty, only one do nothing
        dp[1] = s.charAt(0) == '0' ? 0 : 1; //number of ways to decode upto first letter, if first letter is zero means no mapping to letters hence zero

        for (int i = 2; i <= n; i++) {
            //we have taken the size of dp array as n + 1,
            //so actual current character is s.charAt(i - 1)
            //and previous character is s.charAt(i - 2)

            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            // Decode current digit separately.
            if (curr != '0') {// we dont consider zero as valid number because there no mappings
                dp[i] += dp[i - 1];
            }

            // Decode last two digits together: 10-26.
            if (prev == '1' ||
                (prev == '2' && curr <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}