Pattern Recognition: Digit EXtraction

We need to process each digit of the number.
For every digit, update two things simultaneously: product and sum.
Digits can be extracted using % 10 and removed using / 10.

Brute Force Approach: Convert the number to a string.
Traverse each character, convert it to a digit. Compute product and sum, then return product - sum.
Time: O(d), Space: O(d) (string storage)

Optimal Approach: Use mathematical operations instead of string conversion.
Repeatedly extract the last digit using % 10, update product and sum.
Remove the processed digit using / 10 until the number becomes 0. Time: O(d), Space: O(1) (d = number of digits)

class Solution {
    public int subtractProductAndSum(int n) {

        // Product starts with 1 because multiplying by 1
        // does not affect the result
        int product = 1;

        // Sum starts with 0
        int sum = 0;

        // Process each digit until the number becomes 0
        while (n > 0) {

            // Extract the last digit
            int digit = n % 10;

            // Add digit to the running sum
            sum += digit;

            // Multiply digit into the running product
            product *= digit;

            // Remove the last digit
            n /= 10;
        }

        // Return the required difference
        return product - sum;
    }
}