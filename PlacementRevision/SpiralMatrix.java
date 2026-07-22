Pattern Recognition: Four Boundaries

Brute Force: Maintain another boolean visited[][].
Move in one direction until blocked, then change direction.
Continue until all elements are visited. Time: O(m × n), Space: O(m × n)

Optimal: Maintain four boundaries: top, bottom, left, right.
Print Top → Right → Bottom → Left.
Shrink the corresponding boundary after each traversal. Time: O(m × n), Space: O(1)

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read matrix dimensions
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        // Create matrix
        int[][] matrix = new int[rows][cols];

        // Read matrix elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        /*
         * Four boundaries of the current rectangle
         *
         * top    -> first row
         * bottom -> last row
         * left   -> first column
         * right  -> last column
         */
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        /*
         * Continue until there are no rows or columns left
         */
        while (top <= bottom && left <= right) {

            // ---------------- TOP ROW ----------------
            // Walk Left -> Right
            // Row is fixed (top), Column changes
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }

            // Top row is completely printed
            // Move top boundary one row down
            top++;

            // ---------------- RIGHT COLUMN ----------------
            // Walk Top -> Bottom
            // Column is fixed (right), Row changes
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }

            // Right column is completely printed
            // Move right boundary one column left
            right--;

            // ---------------- BOTTOM ROW ----------------
            // Check because top may have crossed bottom
            if (top <= bottom) {

                // Walk Right -> Left
                // Row is fixed (bottom), Column changes
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }

                // Bottom row is completely printed
                // Move bottom boundary one row up
                bottom--;
            }

            // ---------------- LEFT COLUMN ----------------
            // Check because left may have crossed right
            if (left <= right) {

                // Walk Bottom -> Top
                // Column is fixed (left), Row changes
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }

                // Left column is completely printed
                // Move left boundary one column right
                left++;
            }
        }
    }
}