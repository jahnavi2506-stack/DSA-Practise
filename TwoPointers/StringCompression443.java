Pattern Recognition: Two-Pointers + Run Length Encoding 

Brute Force: Traverse the array and count consecutive repeating characters.
Store the compressed result (char + count) in a new string/array.
Copy the compressed result back if needed and return its length.
Time: O(n), Space: O(n)

Optimal (Two Pointers + Run Length Encoding): Use a read pointer to find each group of consecutive identical characters.
Use a write pointer to write the character and its count (if > 1) back into the same array.
Return the final write pointer position as the compressed length.
Time: O(n), Space: O(1)

class Solution {
    public int compress(char[] chars) {

        // Read pointer: scans the original array
        int i = 0;

        // Write pointer: writes compressed result in-place
        int write = 0;

        // Process all characters
        while (i < chars.length) {

            // Current character whose group we are processing
            char currentChar = chars[i];

            // Count occurrences of currentChar in this consecutive group
            int count = 0;

            // Traverse the entire group of same characters
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Write the character once
            chars[write] = currentChar;
            write++;

            // If group size > 1, write its count
            if (count > 1) {

                // Convert count to string
                // Example: 12 -> "12"
                String countStr = String.valueOf(count);

                // Write each digit separately
                // Example: "12" -> '1', '2'
                for (char digit : countStr.toCharArray()) {
                    chars[write] = digit;
                    write++;
                }
            }
        }

        // write points to the length of compressed array
        return write;
    }
}