Pattern Recognition:- Stack (Order + matching problem) 

Brute Force: For every closing bracket, search backwards to find its matching opening bracket.
Mark matched brackets and continue until the string ends.
Repeated backward searches make it inefficient.
Time Complexity: O(n²)
Space Complexity: O(n) (or O(1) if modifying the input is allowed)

Optimal Approach: Traverse the string once while maintaining a stack of opening brackets.
Push opening brackets; for every closing bracket, check the stack top for a matching opening bracket and pop it.
At the end, the stack must be empty for the string to be valid.
Time Complexity: O(n)
Space Complexity: O(n) (worst case: all opening brackets)

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
                //if return true is written here then it will return true for first matching pair and not check for the rest of the string
                st.pop();
            }
        }

        // Step 5: Final check
        // If stack is empty → all brackets matched
        // Else → some opening brackets are unmatched
        return st.isEmpty();
    }
}