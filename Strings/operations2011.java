Brute Force:
For every operation, compare the string with "++X" / "X++" and increment; otherwise decrement.
Directly process all n operations. Time: O(n) | Space: O(1)

Optimal:
Observe that the middle character op.charAt(1) determines the operation.
'+' → increment, '-' → decrement. Time: O(n) | Space: O(1)

class Solution {

    public int finalValueAfterOperations(String[] operations) {

        // X starts from 0
        int X = 0;

        // Process every operation one by one
        for (String op : operations) {

            // The middle character tells us the operation:
            // "++X" or "X++" → charAt(1) is '+'
            // "--X" or "X--" → charAt(1) is '-'
            if (op.charAt(1) == '+') {
                X++;       // Increment X by 1
            } else {
                X--;       // Decrement X by 1
            }
        }

        // Return the final value of X
        return X;
    }
}
