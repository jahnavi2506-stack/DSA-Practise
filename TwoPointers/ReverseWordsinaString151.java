Pattern Recognition: Two Pointers + String Manipulation.

Brute Force: Split the string using spaces.
Ignore empty strings caused by multiple spaces.
Reverse the list of words and join with " ". Time: O(n), Space: O(n)

Optimal: Use Two Pointers if you want to avoid unnecessary extra structures:
Remove/skip extra spaces and identify each word.Reverse the entire string.
Reverse each individual word. Time: O(n), Space: O(1)

class Solution {
    public String reverseWords(String s) {

        // Remove leading/trailing spaces and split
        // words wherever there are one or more spaces
        String[] words = s.trim().split("\\s+");

        // StringBuilder to construct the reversed result
        StringBuilder result = new StringBuilder();

        // Traverse words from right to left
        for (int i = words.length - 1; i >= 0; i--) {

            // Add a single space between words
            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(words[i]);
        }

        return result.toString();
    }
}