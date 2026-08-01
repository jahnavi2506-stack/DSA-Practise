Pattern Recognition: Array Simulation + Carry

Brute Force: Multiply each digit of num1 with every digit of num2 and create the partial products.
Shift each partial product according to its position and add all partial products as strings.
Time: O(n × m) | Space: O(n + m)

Optimal: Create an integer array of size n + m to store multiplication results and carries.
Use two nested loops to multiply digits and place them directly at result[i+j] / result[i+j+1].
Time: O(n × m) | Space: O(n + m)

class Solution {
    public String multiply(String num1, String num2) {

        // If either number is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();

        // Maximum possible digits in the answer = n + m
        int[] result = new int[n + m];

        // Multiply every digit of num1 with every digit of num2
        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                // Convert character digit to integer digit
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                // Current positions for product and carry
                int product = digit1 * digit2;
                int pos1 = i + j;
                int pos2 = i + j + 1;

                // Add product to the existing value
                int sum = product + result[pos2];

                // Store the digit at the current position
                result[pos2] = sum % 10;

                // Add carry to the previous position
                result[pos1] += sum / 10;
            }
        }

        // Convert the result array into a String
        StringBuilder answer = new StringBuilder();

        for (int digit : result) {

            // Skip leading zeros
            if (answer.length() == 0 && digit == 0) {
                continue;
            }

            answer.append(digit);
        }

        return answer.toString();
    }
}
% 10 → keep the digit
/ 10 → take the carry

Since the numbers are given as strings and I cannot convert them directly to integers, I’ll simulate normal multiplication digit by digit.
I’ll use two nested loops to multiply every digit of num1 with every digit of num2, and store the accumulated products in an integer array of size n + m.
For each multiplication, i + j + 1 stores the current digit and i + j stores the carry. I’ll use % 10 for the digit and / 10 for the carry.
 Finally, I’ll convert the result array into a string while skipping leading zeros."