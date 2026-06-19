class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length() + 1][s1.length() + 1];
        return isInterleave(s1, s2, s3, 0, 0, 0, memo);
    }

    public boolean isInterleave(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (k == n3) {
            return i == n1 && j == n2;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean res = false;

        if (i < n1 && s1.charAt(i) == s3.charAt(k)) {
            if (isInterleave(s1, s2, s3, i + 1, j, k + 1, memo)) {
                res = true;
            }
        }
        
        if (!res && j < n2 && s2.charAt(j) == s3.charAt(k)) {
            if (isInterleave(s1, s2, s3, i, j + 1, k + 1, memo)) {
                res = true;
            }
        }
        memo[i][j] = res;
        return res;
    }
}
