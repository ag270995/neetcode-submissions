class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }


    public boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        boolean currMatch = i < s.length()
            && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            //skip * or zero repitations
            boolean skip = isMatch(s, p, i, j + 2);
            //include * to use same pattern on next charAtomicReference
            boolean include = currMatch && isMatch(s, p, i + 1, j);
            return skip || include;
        }

        return currMatch && isMatch(s, p, i + 1, j + 1);


    }
}
