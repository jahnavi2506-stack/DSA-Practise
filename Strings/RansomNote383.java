Brute Force: For every character in ransomNote, search for the same character in magazine and mark it as used.
Repeated searching makes it slower. Time: O(n × m) | Space: O(m)

Optimal: Count the frequency of all characters in magazine using a 26-size array.
Decrease the count whenever a character is required by ransomNote; if it becomes negative → return false.
Time: O(n + m) | Space: O(1)

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        // Frequency array to store how many times
        // each character 'a' to 'z' occurs in magazine
        int[] freq = new int[26];

        // Count characters available in magazine
        for (int i = 0; i < magazine.length(); i++) {

            // 'a' - 'a' = 0, 'b' - 'a' = 1, ..., 'z' - 'a' = 25
            freq[magazine.charAt(i) - 'a']++;
        }

        // Check whether magazine has enough characters
        // to construct ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {

            // Use one occurrence of the current character
            freq[ransomNote.charAt(i) - 'a']--;

            // If count becomes negative, magazine does not
            // contain enough copies of this character
            if (freq[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // All characters were available in sufficient quantity
        return true;
    }
}