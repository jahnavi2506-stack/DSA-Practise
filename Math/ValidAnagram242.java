Pattern Recognition: HashMap/ Frequency Array

Brute Force (Sorting): If lengths are different, return false.
Sort both strings.If sorted strings are equal, they are anagrams. Time: O(n log n), Space: O(n) (depends on sorting implementation)

optimal: Lengths must be equal. Count every character of s and subtract for every character of t.
If every frequency becomes zero, both strings are anagrams.
Time: O(n), Space: O(1) (26 lowercase letters) 

class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length())
            return false;

        // Frequency array for 26 lowercase English letters
        // Index 0 -> 'a', 1 -> 'b', ..., 25 -> 'z'
        int[] freq = new int[26];

        // Traverse both strings simultaneously
        for (int i = 0; i < s.length(); i++) {

            // Increase count for character in s
            freq[s.charAt(i) - 'a']++;

            // Decrease count for character in t
            freq[t.charAt(i) - 'a']--;
        }

        // If every frequency becomes zero,
        // both strings have exactly the same characters
        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
}