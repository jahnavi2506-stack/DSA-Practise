Pattern Recognition:- Monotonic Stack / Stack-based expression evaluation

BruteForce:- A brute force approach would repeatedly scan the tokens array and rebuild/evaluate 
parts of the expression whenever an operator is found by locating the last two numbers manually.
This leads to O(n²) time complexity due to repeated rescanning, and O(1) space (excluding input) since no extra structured storage is used.

We use equals() because in Java, == checks memory reference, not actual string content. 
Since tokens are Strings created dynamically, we must compare values using equals().

No unexpected input exists- so no default in switch case
class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>(); 
        // Stack is used to store operands (numbers)
        // It follows LIFO → Last In First Out
        // Helps us always access the last 2 numbers quickly

        for(String token : tokens) {

            // check if token is an operator
            if(token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/")) {

                int b = st.pop(); // last operand (top of stack)
                int a = st.pop(); // second last operand

                // IMPORTANT: order matters → a op b (NOT b op a)

                switch(token) {
                    case "+":
                        st.push(a + b); 
                        break; // push result back into stack

                    case "-":
                        st.push(a - b);
                        break; // subtraction is order-sensitive

                    case "*":
                        st.push(a * b);
                        break;

                    case "/": // "/" is STRING here because token is String
                        // Integer division in Java truncates toward 0
                        st.push(a / b);
                        break;
                }
            } 
            else {
                // token is a number in String form (e.g. "2", "-11")
                // convert String → Integer before pushing
                st.push(Integer.parseInt(token)); 
            }
        }

        // After full traversal, only one element remains in stack
        // This is the final evaluated result of the expression
        return st.pop();
    }
}