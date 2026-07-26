Pattern Recognition: Transpose + Reverse Rows = 90° Clockwise Rotation[Matrix Transformation]

Brute Force: Create a new n × n matrix.
For every element, place matrix[i][j] at newMatrix[j][n-1-i].
Copy the new matrix back to the original if required. Time: O(n²), Space: O(n²)

Optimal Approach: First transpose the matrix by swapping matrix[i][j] with matrix[j][i].
Then reverse every row to achieve a 90° clockwise rotation.
All operations are performed directly on the input matrix (in-place). Time: O(n²), Space: O(1)

class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // -------------------------------
        // Step 1: Transpose the matrix
        // Swap matrix[i][j] with matrix[j][i]
        // (Only traverse the upper triangle to avoid double swapping)
        // -------------------------------
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // -------------------------------
        // Step 2: Reverse every row
        // This converts the transposed matrix
        // into a 90° clockwise rotated matrix.
        // -------------------------------
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}