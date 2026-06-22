class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    public boolean helper(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        boolean curr = i < s.length() && j < p.length() && ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean skip = helper(s, p, i, j + 2);
            boolean include = curr && helper(s, p, i + 1, j);
            return skip || include;
        }
        return curr && helper(s, p, i + 1, j + 1);
    }
}
