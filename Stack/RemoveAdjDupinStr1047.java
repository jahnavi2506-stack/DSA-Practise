pattern recognition:-Adjacent cancellation / reduction problem

class Solution {
    public String removeDuplicates(String s) {

        // Stack to store characters after removing adjacent duplicates
        Stack<Character> st = new Stack<>();

        // Step 1: Traverse the input string character by character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Step 2: If stack is not empty AND top matches current character
            // → duplicate pair found, so remove previous character
            if (!st.isEmpty() && st.peek() == ch) {
                st.pop();   // remove the matching previous character
            } 
            else {
                // Step 3: No duplicate, so safely add current character
                st.push(ch);
            }
        }

        // Step 4: Build the result from stack
        // (stack stores result in reverse order due to LIFO nature)
        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());  // extract characters from stack
        }

        // Step 5: Reverse to get correct order
        sb.reverse();

        // Step 6: Convert StringBuilder to String and return
        return sb.toString();
    }
}

class Solution {
    public String removeDuplicates(String s) {

        // StringBuilder acts like a dynamic stack
        StringBuilder sb = new StringBuilder();

        // Step 1: Traverse each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Step 2: Check last character in sb (stack top equivalent)
            int len = sb.length();

            if (len > 0 && sb.charAt(len - 1) == ch) {
                // duplicate found → remove last character (pop)
                sb.deleteCharAt(len - 1);
            } else {
                // no duplicate → add character (push)
                sb.append(ch);
            }
        }

        // Step 3: final result is already in correct order
        return sb.toString();
    }
}