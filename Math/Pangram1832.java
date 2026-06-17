Pattern Recognition: Hashset or boolean array or bitmask

Brute Force Approach: For every letter from 'a' to 'z', check whether it exists in the string.
If any letter is missing, return false.
If all 26 letters are found, return true. Time: O(26 × n) ≈ O(n), Space: O(1)

Optimal Approach (Boolean Array): Create a boolean array of size 26.Mark each character as seen.
Check whether all 26 positions are marked. Time: O(n), Space: O(26) ≈ O(1)

Bitmask Approach: Use one integer's bits to represent the 26 letters.
Turn ON the corresponding bit whenever a letter appears.
If all 26 bits are ON, it's a pangram. Time: O(n), Space: O(1)

class Solution {
    public boolean checkIfPangram(String sentence) {

        // Stores which letters have appeared
        int mask = 0;

        // Traverse every character
        for (char ch : sentence.toCharArray()) {

            // Convert character to position (0-25)
            int pos = ch - 'a';

            // Turn ON the corresponding bit
            mask |= (1 << pos);
        }

        // Number with all 26 bits set to 1
        int allLetters = (1 << 26) - 1;

        // If both are equal, every letter appeared
        return mask == allLetters;
    }
}

Why choose Bitmask? Boolean Array Stores 26 separate boolean values, but Bitmask Stores all 26 letters inside a single integer using bits.