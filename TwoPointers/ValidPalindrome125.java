Pattern recognition: Two-pointers

Brute Force Approach (Create Clean String): Traverse the string and keep only letters and digits.
Convert everything to lowercase. Check if the cleaned string is a palindrome. Time: O(n), Space: O(n) (extra string)

Optimal Approach (Two Pointers): Keep one pointer at the beginning and another at the end.
Skip non-alphanumeric characters.
Compare lowercase characters directly without creating another string.
Time: O(n), Space: O(1)

class Solution {
    public boolean isPalindrome(String s) {

        // Left pointer starts from beginning
        int left = 0;

        // Right pointer starts from end
        int right = s.length() - 1;

        // Continue until pointers meet
        while (left < right) {

            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Convert both characters to lowercase
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));

            // If characters are different, not a palindrome
            if (l != r)
                return false;

            // Move both pointers
            left++;
            right--;
        }

        // All characters matched
        return true;
    }
}

The outer while answers: "Should we continue comparing characters?"
The inner while answers: "While skipping invalid characters, are the pointers still in a valid position?"
