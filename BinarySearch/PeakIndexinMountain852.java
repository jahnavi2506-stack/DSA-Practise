Pattern Recognition: Binary Search Pattern         

Brute Force Approach: Traverse the entire array linearly and keep checking which element is maximum.
Update the peak index whenever a larger element is found.
Return the index of the maximum element at the end. Time  : O(n), Space : O(1)

Optimal: Use binary search and compare `arr[mid]` with `arr[mid + 1]` to identify slope direction.
If `arr[mid] < arr[mid + 1]`, peak lies on right (increasing slope). Otherwise, peak lies at mid or left (decreasing slope).
Repeatedly eliminate half of the array until both pointers converge to the peak index. Time  : O(log n), Space : O(1)

class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        // Start pointer
        int left = 0;

        // End pointer
        int right = arr.length - 1;

        // Binary Search
        while (left < right) {

            // Find middle index safely
            int mid = left + (right - left) / 2;

            /*
             If current element is smaller than next element,
             we are on increasing slope.

             Example:
             3 -> 7

             Peak lies on RIGHT side.
            */
            if (arr[mid] < arr[mid + 1]) {

                // Discard left half including mid
                left = mid + 1;

            } else {

                /*
                 We are on decreasing slope.

                 Example:
                 9 -> 5

                 Peak is either:
                 - at mid
                 - or on LEFT side
                */

                // Keep mid because it can be peak
                right = mid;
            }
        }

        /*
         left == right

         Both pointers converge at peak index.
        */
        return left;
    }
}

