//HackerRank

Pattern Recognition: Array Reversal + Two Pointers
Use `left = 0` and `right = n-1`, then swap elements while `left < right`.
Time: O(n) | Space: O(1) if reversing in-place.

Brute Force: Traverse the array from **right to left** and store elements in a new array.
Example: `[1, 2, 3, 4] → [4, 3, 2, 1]`.
Time: O(n) | Space: O(n).

Optimal: Keep two pointers at both ends: `left = 0`, `right = n-1`.
Swap `arr[left]` and `arr[right]`, then do `left++` and `right--` until `left >= right`.
Time: O(n) | Space: O(1).

| LeetCode — familiar | HackerRank — this problem |
| ------------------- | ------------------------- |
| `int[] arr`         | `List<Integer> a`         |
| `arr.length`        | `a.size()`                |
| `arr[i]`            | `a.get(i)`                |
| `arr[i] = x`        | `a.set(i, x)`             |

 public static List<Integer> reverseArray(List<Integer> a) {

        // Two pointers: one starts from the beginning,
        // the other starts from the end.
        int left = 0;
        int right = a.size() - 1;  // List uses size(), not length

        // Continue until the pointers meet/cross
        while (left < right) {

            // Swap a[left] and a[right]
            // List uses get() to read a value
            // and set() to change a value.
            int temp = a.get(left);
            a.set(left, a.get(right));
            a.set(right, temp);

            // Move both pointers towards the center
            left++;
            right--;
        }

        // Return the reversed List
        return a;
    }
