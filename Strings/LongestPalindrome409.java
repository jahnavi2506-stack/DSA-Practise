Pattern Recognition: Count frequencies → calculate maximum palindrome length

Brute Force: Generate different arrangements/subsequences of characters and check whether each is a palindrome.
Keep the maximum length among valid palindromes.
Time: O(n!) or worse depending on generation; Space: O(n).

Optimal Approach: Count each character's frequency using a HashMap → O(n).
Add all even frequencies; for odd frequencies add frequency - 1, and remember that an odd exists.
If any odd exists, add 1 for the center → Time: O(n), Space: O(k) where k = distinct characters.

class Solution {

    public int longestPalindrome(String s) {

        // Step 1: Store frequency of each character
        // Character -> Number of times it occurs
        HashMap<Character, Integer> map = new HashMap<>();

        // Count every character in the string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If character exists, increase its count by 1.
            // If it doesn't exist, getOrDefault returns 0.
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Stores the maximum palindrome length we can form
        int length = 0;

        // Tells us whether there is at least one odd frequency
        boolean hasOdd = false;

        // Step 2: Process each character's frequency
        for (int values : map.values()) {

            // EVEN frequency:
            // We can use all characters because they can form pairs.
            // Example: c = 4 -> use all 4
            if (values % 2 == 0) {

                length += values;
            }

            // ODD frequency:
            else {

                // Use the largest even portion.
                // Example: 5 -> use 4, 3 -> use 2, 1 -> use 0
                length += values - 1;

                // Remember that an odd character exists.
                // One such character can be placed in the center.
                hasOdd = true;
            }
        }

        // If at least one odd-frequency character exists,
        // we can place ONE character in the center.
        if (hasOdd) {

            length += 1;
        }

        // Return the maximum possible palindrome length
        return length;
    }
}