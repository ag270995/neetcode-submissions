class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int index = 0; index < s.length(); index++) {
            ++arr[(int) s.charAt(index) - 'a'];
            --arr[(int) t.charAt(index) - 'a'];
        }
        for (int element : arr) {
            if (element != 0)
                return false;
        }
        return true;
    }
}
