Pattern recognition:- Simulating recursion using an explicit stack

Recursion → implicit stack (system stack)
Stack → explicit control by us

BruteForce: Try every time we see k[encoded_string], rebuild substring by scanning/re-parsing repeatedly.
Time: O(n²) (can worsen due to repeated processing), Space: O(n)

Optimal (Stack-based): Scan once, use stack to store (previous string + repeat count) at each [, and build result in single pass.
Time: O(n), Space: O(n)

At each '[' we need to store two independent pieces of state — the current string built so far and the repeat count.
Since these are independent and need to be restored later in LIFO order, we use two stacks: one for strings and one for integers.

class Solution {
    public String decodeString(String s) {

        // Stack to store previous strings before encountering '['
        Stack<String> stringStack = new Stack<>();

        // Stack to store repeat counts (k values)
        Stack<Integer> countStack = new Stack<>();

        // Current working string (what we are building at this level)
        String currentString = "";

        // Current number being formed (handles multi-digit numbers like 12, 300)
        int currentNum = 0;

        // Traverse input string character by character
        for (char ch : s.toCharArray()) {

            // CASE 1: DIGIT
            // Build multi-digit number
            // Example: "12" → 1 then 2 → 12
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            }

            // CASE 2: '['
            // Save current state before going inside bracket
            // Push current string and repeat count
            // Then reset for inner expression
            else if (ch == '[') {
                stringStack.push(currentString);
                countStack.push(currentNum);

                currentString = ""; // start fresh inside bracket
                currentNum = 0;     // reset number builder
            }

            // CASE 3: ']'
            // End of current bracketed expression
            // Pop previous state and build result
            else if (ch == ']') {

                int repeatTimes = countStack.pop();     // how many times to repeat
                String prevString = stringStack.pop();  // string before '['

                StringBuilder temp = new StringBuilder(prevString);

                // repeat currentString k times
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }

                // update currentString with merged result
                currentString = temp.toString();
            }

            // CASE 4: NORMAL CHARACTER
            // Just append to current working string
            else {
                currentString += ch;
            }
        }

        // Final decoded string
        return currentString;
    }
}
StringBuilder is used because strings are immutable in Java, 
and repeated concatenation creates many temporary objects, while StringBuilder modifies the same buffer efficiently.