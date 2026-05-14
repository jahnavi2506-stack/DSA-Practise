Pattern Recognition:- Sorting + Hashmap(value mapping)

Brute Force Approach:
For every element, compare it with every other element and count how many UNIQUE smaller elements exist.
Rank of current element = (count of unique smaller elements) + 1, and equal elements get same rank.
Time Complexity: O(n²) , Space Complexity: O(n) (for storing result / duplicate tracking).

Optimal Approach:
Create a sorted copy of the array, traverse it, and assign ranks only to UNIQUE values using a HashMap (value -> rank).
Then traverse the original array and replace each element using hashmap lookup to maintain original order efficiently.
Time Complexity: O(n log n) due to sorting, Space Complexity: O(n) for sorted array + hashmap.

class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;

        // Edge case: empty array
        if (n == 0) {
            return arr;
        }

        // Create a copy because sorting original array
        // would destroy original order
        int[] sorted = arr.clone();

        // Sort array to process elements in increasing order
        Arrays.sort(sorted);

        // Map: value -> rank
        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        // Assign ranks only to unique values
        for (int num : sorted) {

            // If value not already ranked
            if (!map.containsKey(num)) {

                // Store current rank
                map.put(num, rank);

                // Increase rank only for new unique values
                rank++;
            }
        }

        // Replace original elements with their ranks
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        // Final ranked array
        return arr;
    }
}