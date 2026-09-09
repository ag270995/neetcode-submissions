class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) {
            return false;
        }

        Map<Character, Integer> f1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            f1.put(c, f1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> f2 = new HashMap<>();
        int l = 0;
        for (int r = 0; r < n2; r++) {
            char rc = s2.charAt(r);
            f2.put(rc, f2.getOrDefault(rc, 0) + 1);

            if (r - l + 1 > n1) {
                char lc = s2.charAt(l);
                f2.put(lc, f2.get(lc) - 1);
                if (f2.get(lc) == 0) {
                    f2.remove(lc);
                }
                l++;
            }

            if (r - l + 1 == n1) {
                if (f1.equals(f2)) {
                    return true;
                }
            }
        }
        return false;
    }
}