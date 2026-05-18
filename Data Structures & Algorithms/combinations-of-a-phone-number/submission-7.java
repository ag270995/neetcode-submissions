class Solution {
    String[] keys = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        helper(0, new StringBuilder(), digits);
        return res;
    }

    public void helper(int i, StringBuilder sb, String digits) {
        int n = digits.length();
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }
        if (i > n) {
            return;
        }
        String letters = keys[digits.charAt(i) - '0'];
        for (int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));
            helper(i + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
