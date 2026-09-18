class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int top = stack.pop();
                int prevTop =  stack.pop();
                stack.push(prevTop + top);
            } else if ("-".equals(token)) {
                int top = stack.pop();
                int prevTop =  stack.pop();
                stack.push(prevTop - top);
            } else if ("*".equals(token)) {
                int top = stack.pop();
                int prevTop =  stack.pop();
                stack.push(prevTop*top);
            } else if ("/".equals(token)) {
                int top = stack.pop();
                int prevTop =  stack.pop();
                stack.push(prevTop/top);
            } else {
                stack.push(Integer.parseInt(token));
            }

        }
        return stack.peek();
    }
}
