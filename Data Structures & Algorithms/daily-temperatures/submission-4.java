class Solution {
   
// problem in simple terms is - we need to find the next greater number on the right side of the array for the current index and update their index difference
// intuitively, this means - we need to scan from left + 1 to right, and also at the current index, we don't know what comes on the right, so we initially
// store the index whose result is not known at this point.
// then, in the next iterations, if there comes an element whose temperature is more than it, update the result and pop the index from the stack, because it's already calculated
// repeat the process till the current index's temperature is no longer greater than the entries in the stack or if the stack is empty.


    // why time complexity is O(n) because :-
    // The while loop doesn't run n times for every iteration of the outer loop. Every time the while loop executes, an element is popped from the stack, and each element can be popped at most once. So the total number of while iterations across the entire algorithm is at most n. Therefore, the overall complexity is O(n).
    
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() 
                        && temperatures[stack.peek()] < temperatures[i]) {
                    res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
