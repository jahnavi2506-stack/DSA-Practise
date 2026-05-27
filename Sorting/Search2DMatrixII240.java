Pattern Recognition: Binary Search on a 2D Matrix Search using elimination(Search Space Reduction)

Brute Force Approach: Traverse every element in the matrix using nested loops.
Compare each element with the target.
Return `true` if found, otherwise return `false`. Time  : O(m * n), Space : O(1)

Optimal Approach (Staircase Search): Start from the TOP-RIGHT corner of the matrix.
If current > target → move LEFT, if current < target → move DOWN.
Eliminate one full row or column in every step. Time  : O(m + n), Space : O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows
        int rows = matrix.length;

        // Number of columns
        int cols = matrix[0].length;

        /*
         Start from TOP RIGHT corner.

         Why?

         Because:
         - Left side elements are smaller
         - Down side elements are larger

         This helps us eliminate one row or one column
         in every step.
        */

        // Start row
        int row = 0;

        // Start column (top-right corner)
        int col = cols - 1;

        /*
         Continue while:
         - row is inside matrix
         - col is inside matrix
        */
        while (row < rows && col >= 0) {

            // Current element
            int current = matrix[row][col];

            // Target found
            if (current == target) {
                return true;
            }

            /*
             Current element is greater than target.

             Move LEFT because:
             - all elements below are even bigger
             - target cannot exist downward
            */
            else if (current > target) {
                col--;
            }

            /*
             Current element is smaller than target.

             Move DOWN because:
             - all elements on left are smaller
             - target cannot exist on left side
            */
            else {
                row++;
            }
        }

        // Target not found
        return false;
    }
}
"If problem says: Rows sorted, Columns sorted then immediately think: Start from TOP RIGHT"

