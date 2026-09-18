//HackerRank

Pattern Recognition: Pattern: Array Rotation / Circular Array.
Left rotate by d → split at index d.
Final order = [d → n-1] + [0 → d-1].

Brute Force: Perform one left rotation d times; each rotation shifts all elements left by one.
For each rotation: save first element → shift → place saved element at the end. Time: O(n × d) | Space: O(1).

Optimal: Directly construct the result by taking elements from index d to n-1, then 0 to d-1.
No need to perform the rotations one by one. Time: O(n) | Space: O(n).

public class Solution {

    static List<Integer> rotateLeft(int d, List<Integer> arr) {

        // Create a new list to store the rotated array
        List<Integer> result = new ArrayList<>();

        // 1. Add elements from index d to the end
        // Example: [1, 2 | 3, 4, 5] → add [3, 4, 5]
        for (int i = d; i < arr.size(); i++) {
            result.add(arr.get(i));
        }

        // 2. Add the first d elements at the end
        // Example: [1, 2 | 3, 4, 5] → add [1, 2]
        for (int i = 0; i < d; i++) {
            result.add(arr.get(i));
        }

        // Return the rotated array
        return result;
    }
}