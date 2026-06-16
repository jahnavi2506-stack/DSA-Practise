Pattern Recognition: String pattern (Rotation Check)

Brute Force: Generate all possible left rotations of s.
After each rotation, compare it with goal.
If any rotation matches, return true; otherwise return false. Time: O(n²), Space: O(n)

Optimal Approach: First check if s and goal have the same length.
Create doubled = s + s. If goal is a substring of doubled, it is a valid rotation. Time: O(n), Space: O(n)

class Solution {
    public boolean rotateString(String s, String goal) {

        // Rotation is only possible if both strings
        // have the same length
        if (s.length() != goal.length()) {
            return false;
        }

        // Double the string to simulate circular rotation
        // Example:
        // s = "abcde"
        // s+s = "abcdeabcde"
        String doubled = s + s;

        // Every valid rotation of 's' will appear
        // as a substring inside (s + s)
        return doubled.contains(goal);
    }
}