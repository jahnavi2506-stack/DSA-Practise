Pattern Recognition: Binary Search on a virtual sorted 1D array

Brute Force: Traverse every element of the matrix using nested loops.
Compare each element with the target.
If target is found return true, otherwise return false.
Time  : O(m * n), Space : O(1)

Optimal: Treat the entire matrix as a single sorted 1D array.
Apply Binary Search from index 0 to (m*n)-1.
Convert virtual 1D index to 2D
Time  : O(log(m * n)), Space : O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows
        int rows = matrix.length;

        // Number of columns
        int cols = matrix[0].length;

        /*
         We will treat the 2D matrix like a 1D sorted array.

         Example:

         Matrix:
         [
           [1, 3, 5, 7],
           [10,11,16,20],
           [23,30,34,60]
         ]

         Virtual 1D array:
         Index : 0  1  2  3  4   5   6   7   8   9   10  11
         Value : 1  3  5  7  10  11  16  20  23  30  34  60
        */

        // Binary Search range
        int low = 0;

        // Last index of virtual 1D array
        int high = (rows * cols) - 1;

        // Standard Binary Search
        while (low <= high) {

            // Find middle index
            int mid = low + (high - low) / 2;

            /*
             Convert virtual 1D index into 2D coordinates

             row = mid / cols
             col = mid % cols

             Example:
             mid = 10
             cols = 4

             row = 10 / 4 = 2
             col = 10 % 4 = 2

             matrix[2][2] = 34
            */

            int row = mid / cols;
            int col = mid % cols;

            // Current element at calculated position
            int current = matrix[row][col];

            // Target found
            if (current == target) {
                return true;
            }

            // Current value smaller than target
            // Move RIGHT in binary search
            else if (current < target) {
                low = mid + 1;
            }

            // Current value greater than target
            // Move LEFT in binary search
            else {
                high = mid - 1;
            }
        }

        // Target not found
        return false;
    }
}

/ - tells WHICH ROW, % - tells POSITION INSIDE ROW