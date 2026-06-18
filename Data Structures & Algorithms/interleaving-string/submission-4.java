class Solution {
    String a;
    String b;
    String c;
    public boolean isInterleave(String s1, String s2, String s3) {
        a = s1;
        b = s2;
        c = s3;
        if (s1.length() + s2.length() != s3.length()) {
    return false;
    }
        return isInterleave(0, 0, 0);
    }


    public boolean isInterleave(int i, int j, int k) {
        int n1 = a.length();
        int n2 = b.length();
        int n3 = c.length();
        if (i == n1 && j == n2) {
            if (k == n3 ) {
                return true;
            }
            return false;
        }
        if (i < n1 && j == n2) {
            if (k < n3 && a.charAt(i) == c.charAt(k)) {
                return isInterleave(i + 1, j, k + 1);
            }
            return false;

        }

        if (j < n2 && i == n1) {
            if (k < n3 && b.charAt(j) == c.charAt(k)) {
                return isInterleave(i, j + 1, k + 1);
            }
            return false;

        }

        if (a.charAt(i) == c.charAt(k) && b.charAt(j) == c.charAt(k)) {
            return isInterleave(i + 1, j, k + 1) || isInterleave(i, j + 1, k + 1);
        } else if (a.charAt(i) == c.charAt(k)) {
            return isInterleave(i + 1, j, k + 1);
        } else if (b.charAt(j) == c.charAt(k)) {
            return isInterleave(i, j + 1, k + 1);
        }
        return false;
    }
}
