Pattern Recognition:-Stack Simulation of Text Editing / Undo Operations

class Solution {
    public String removeStars(String s) {

        // Stack to store characters that are still valid after processing
        Stack<Character> st = new Stack<>();

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If current character is '*', we treat it as BACKSPACE
            if (ch == '*') {

                // Remove last inserted character if stack is not empty
                if (!st.isEmpty()) {
                    st.pop();  // undo last valid character
                }

            } else {
                // Normal character → add to stack
                st.push(ch);
            }
        }

        // Build final result from stack
        StringBuilder sb = new StringBuilder();

        // Stack gives reverse order, so we pop all elements
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        // Reverse to restore correct order
        sb.reverse();

        // Return final processed string
        return sb.toString();
    }
}