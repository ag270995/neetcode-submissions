class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return res;
            }
            helper(0, digits, new StringBuilder());
            return res;
    }

    public void helper(int i, String digits, StringBuilder sb) {
        int n = digits.length();
        if (i >= n) {
            res.add(sb.toString());
            return;
        }
        String letters = digitToChar[digits.charAt(i) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            helper(i + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    } 
}
