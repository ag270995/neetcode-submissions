class Solution {
    List<String> curr = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(0, s, s.length());
        return res;
    }

    void helper(int i, String s, int n) {
        if (i >= n) {
            res.add(new ArrayList<>(curr));    
            return;
        }
        for (int j = i; j < n; j++) {
            if (check(s, i, j)) {
                curr.add(s.substring(i, j + 1));
                helper(j + 1, s, n);
                curr.remove(curr.size() - 1);
            }
        }
    }


    boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }



}
