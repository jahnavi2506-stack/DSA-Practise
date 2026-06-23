Pattern Recognition: Frequency Array

Brute Force Approach: Sort both strings and compare the resulting strings.
If the sorted strings are equal, return true; otherwise false.
Time Complexity: O(n log n), Space Complexity: O(n).

Optimal Approach: Use a frequency array of size 26 for lowercase English letters.
Increment counts for characters in s and decrement for characters in t.
If all frequencies become 0, the strings are anagrams. Time Complexity: O(n)

class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase letters
        int[] freq = new int[26];

        // Count characters from s
        // Remove characters from t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
