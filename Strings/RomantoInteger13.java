Pattern Recognition: String + Simulation

This is a String Simulation problem. We traverse the Roman numeral string once and simulate the Roman numeral rules 
by comparing each symbol with its next symbol

Brute Force Approach (Special Pairs Handling)
Traverse the string and check whether the current and next characters form one of the six special Roman pairs (IV, IX, XL, XC, CD, CM).
If a special pair is found, add its value and move two positions ahead.
Otherwise, add the value of the current character and move one position ahead. Time: O(n), Space: O(1)

Optimal Approach (Compare Current with Next): Traverse the string once and convert each Roman symbol to its integer value.
If the current value is smaller than the next value, subtract it; otherwise, add it.
Keep accumulating the result and add the last character normally. Time: O(n), Space : O(1)

class Solution {
    public int romanToInt(String s) {

        // Stores final integer value
        int result = 0;

        // Traverse each character in the Roman numeral
        for (int i = 0; i < s.length(); i++) {

            // Convert current Roman character to its integer value
            int current = getValue(s.charAt(i));

            /*
             * If current character is not the last character,
             * compare it with the next character.
             */
            if (i < s.length() - 1) {

                int next = getValue(s.charAt(i + 1));

                /*
                 * Roman Numeral Rule:
                 * If current value is smaller than next value,
                 * it is a subtractive case (IV, IX, XL, XC, CD, CM)
                 */
                if (current < next) {
                    result -= current;
                } else {
                    result += current;
                }

            } else {

                // Last character is always added
                result += current;
            }
        }

        return result;
    }

    /*
     * Helper method:
     * Converts a Roman numeral character to its integer value.
     */
    private int getValue(char ch) {

        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0; // Never reached because input is guaranteed valid
    }
}