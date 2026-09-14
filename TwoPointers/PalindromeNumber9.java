Pattern Recognition: digit extraction + reversal

Brute Force: Convert `x` to a `String`, reverse the string, and compare it with the original.
If both are equal → palindrome; otherwise → not palindrome.
Time: O(log₁₀ n), Space: O(log₁₀ n)

Optimal: Reverse only half of the number and compare the reversed half with the remaining half.
Avoids converting to a string and avoids overflow from reversing the entire number.
Time: O(log₁₀ n), Space: O(1)

class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // Store the original number
        int original = x;

        // This will store the reversed number
        int reverse = 0;

        // Reverse the number
        while (x > 0) {

            // Get the last digit
            int digit = x % 10;

            // Add the digit to reverse
            reverse = reverse * 10 + digit;

            // Remove the last digit from x
            x = x / 10;
        }

        // If original and reverse are same → palindrome
        return original == reverse;
    }
}