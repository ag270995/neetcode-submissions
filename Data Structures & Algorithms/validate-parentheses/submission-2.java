class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (st.isEmpty()) {
                    return false;
                } else if (!st.isEmpty() && st.peek() == map.get(c)) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                 st.add(c);
            }
           
        }

        return st.isEmpty();
    }
}
