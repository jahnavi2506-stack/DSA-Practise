Pattern Recognition: Digit Carry Propagation

Brute Force: Convert array into a number. Add 1. Convert number back into an array. Time: O(n),Space: O(n)
For constraints larger than normal integer limits, the number may overflow.

Optimal Approach: Start from the last digit.If digit is less than 9, increment it and return immediately.
If digit is 9, make it 0 and carry 1 to the left. Time: O(n), Space: O(1)

class Solution {
    public int[] plusOne(int[] digits) {

        // Traverse from right to left
        for (int i = digits.length - 1; i >= 0; i--) {

            // If digit is less than 9,
            // simply increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9,
            // it becomes 0 and carry moves left
            digits[i] = 0;
        }

        // If we reach here,
        // all digits were 9
        // Example: [9,9,9] -> [1,0,0,0]
        int[] result = new int[digits.length + 1];

        // Place leading 1
        result[0] = 1;

        return result;
    }
}