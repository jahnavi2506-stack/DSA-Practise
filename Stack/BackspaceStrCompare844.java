Pattern Recognition:- Reverse Traversal + Skip Logic

class Solution {

    // Helper function to simulate typing with backspaces
    public String Process(String str) {

        // Stack to store characters after processing
        Stack<Character> st = new Stack<>();

        // Traverse the string from left to right
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If current character is '#', simulate backspace
            if(ch == '#') {
                // Remove last character if stack is not empty
                if(!st.isEmpty()) {
                    st.pop();
                }
            } 
            // If normal character, push into stack
            else {
                st.push(ch);
            }
        }

        // Build final string from stack
        StringBuilder sb = new StringBuilder();

        // Pop all elements (will be in reverse order)
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        // Reverse to get correct order and return
        return sb.reverse().toString();
    }

    // Main function to compare two strings after processing
    public boolean backspaceCompare(String s, String t) {

        // Process both strings
        String finalS = Process(s);
        String finalT = Process(t);

        // Compare final results
        return finalS.equals(finalT);
    }
}//o(n) time complexity, o(n) space complexity

class Solution {

    public boolean backspaceCompare(String s, String t) {

        // Step 1: Start pointers from end of both strings
        int i = s.length() - 1;
        int j = t.length() - 1;

        // Step 2: Skip counters to handle backspaces
        int skipS = 0;
        int skipT = 0;

        // Step 3: Traverse until both strings are fully processed
        while(i >= 0 || j >= 0) {

            // ---------------- PROCESS STRING s ----------------
            // Find next valid character in s
            while(i >= 0) {

                // If current char is '#', increase skip count
                if(s.charAt(i) == '#') {
                    skipS++;
                    i--;
                }

                // If we have characters to skip, ignore them
                else if(skipS > 0) {
                    skipS--;
                    i--;
                }

                // Found valid character
                else {
                    break;
                }
            }

            // ---------------- PROCESS STRING t ----------------
            // Find next valid character in t
            while(j >= 0) {

                // If current char is '#', increase skip count
                if(t.charAt(j) == '#') {
                    skipT++;
                    j--;
                }

                // Skip characters due to previous '#'
                else if(skipT > 0) {
                    skipT--;
                    j--;
                }

                // Found valid character
                else {
                    break;
                }
            }

            // Step 4: Get current valid characters (or dummy if none)
            char ch1 = (i >= 0) ? s.charAt(i) : '$';
            char ch2 = (j >= 0) ? t.charAt(j) : '$';

            // Step 5: Compare current characters
            // If mismatch found → strings are not equal
            if(ch1 != ch2) return false;

            // Step 6: Move both pointers backward
            i--;
            j--;
        }

        // Step 7: If no mismatch found → strings are equal
        return true;
    }
}
