class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n2 < n1) {
            return false;            
        }
        Map<Character, Integer> f1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            f1.merge(s1.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> f2 = new HashMap<>();

        int l = 0;
        for (int r = 0; r < n2; r++) {
            char rightChar = s2.charAt(r);
            //fancy way to update(increment) frequency
            f2.merge(rightChar, 1, Integer::sum);

            if (r - l + 1 > n1) {
                char leftChar = s2.charAt(l);
                //fancy way to update(decrement) frequency
                f2.merge(leftChar, -1, Integer::sum);
                if (f2.get(leftChar) == 0) {
                    //once freq is zero then we are removing key from map 
                    //so that we can do equals operation with f1 map, which matches keys and values
                    //extra key even with frequency zero will cause it to fail equal condition
                    f2.remove(leftChar);
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