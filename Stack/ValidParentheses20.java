Pattern Recognition:-Order + matching problem 

class Solution {
    public boolean isValid(String s) {

        // Stack to store opening brackets
        Stack<Character> st = new Stack<>();

        // Traverse each character of the string
        for(int i = 0; i < s.length(); i++) {

            // Get current character
            char ch = s.charAt(i);

            // Step 1: If opening bracket → push to stack
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else {
                // Step 2: If closing bracket but stack is empty → no match
                if(st.isEmpty()) return false;

                // Get top element (last unmatched opening bracket)
                char top = st.peek();

                // Step 3: Check mismatch conditions
                // If current closing bracket does NOT match top opening bracket → invalid
                if (
                    (ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')
                ) {
                    return false;
                }

                // Step 4: If matched → remove opening bracket
                st.pop();
            }
        }

        // Step 5: Final check
        // If stack is empty → all brackets matched
        // Else → some opening brackets are unmatched
        return st.isEmpty();
    }
}