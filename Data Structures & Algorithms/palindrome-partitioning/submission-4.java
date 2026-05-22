class Solution {
    
    List<String> curr = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPallindrom(s, i , j)) {
                    dp[i][j] = true;
                }
            }
        }    
        helper(0, s, dp);
        return res;
    }

    public void helper(int i, String s, boolean[][] dp) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (!dp[i][j]) {
                continue;
            }
            curr.add(s.substring(i, j + 1));
            helper(j + 1, s, dp);
            curr.remove(curr.size() - 1);
        } 

    }

    public boolean isPallindrom( String str, int i, int j) {
        
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
