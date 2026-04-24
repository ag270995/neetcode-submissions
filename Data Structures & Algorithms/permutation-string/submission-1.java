class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        
        int[] f1 = new int[26];
        for (int i = 0; i < n1; i++) {
            f1[(int) s1.charAt(i) - 'a']++;
        }

        int l = 0;
        int[] f2 = new int[26];
        for (int r = 0; r < n2; r++) {
            f2[(int) s2.charAt(r) - 'a']++;
            if (r - l + 1 > n1) {
                f2[(int) s2.charAt(l) - 'a']--;
                l++;
            }
            if (r - l + 1 == n1) {
                if (Arrays.equals(f1, f2)) {
                    return true;
                }
            }

        }
        return false;
    }

}
