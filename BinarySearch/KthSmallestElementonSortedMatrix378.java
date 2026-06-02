Pattern Recognition: Binary Search on answer space.

Brute Force
Put all n² elements into a 1D array and sort it.
Return the element at index k - 1.
Time: O(n² log n) , Space: O(n²)

Better Approach (Min Heap)
Treat each row as a sorted list and put the first element of every row into a min heap.
Pop the smallest element k times; after popping from a row, push the next element from that same row.
Time: O(k log n) , Space: O(n)

Optimal Approach (Binary Search on Answer)
Binary search on the value range [matrix[0][0], matrix[n-1][n-1]].
For each mid, count how many elements are ≤ mid using the bottom-left counting trick in O(n).
Time: O(n log(maxValue - minValue)) , Space: O(1)

The key difference is:

Heap finds the kth smallest by extracting elements one-by-one.
Binary Search finds the kth smallest by counting how many elements are ≤ a value.
For this problem: Heap:- Give me the next smallest.  Binary Search:- How many numbers are ≤ mid?

class Solution {
public int kthSmallest(int[][] matrix, int k) {

    int n = matrix.length;

    // Smallest possible answer
    int low = matrix[0][0];

    // Largest possible answer
    int high = matrix[n - 1][n - 1];

    // Binary Search on ANSWER, not on indices
    while (low < high) {

        int mid = low + (high - low) / 2;

        // Count elements <= mid
        int count = countLessOrEqual(matrix, mid);

        // Not enough elements <= mid,
        // so kth smallest must be larger
        if (count < k) {
            low = mid + 1;
        }

        // Enough elements <= mid,
        // so answer could be mid or smaller
        else {
            high = mid;
        }
    }

    // low == high = kth smallest element
    return low;
}

private int countLessOrEqual(int[][] matrix, int target) {

    int n = matrix.length;

    // Start from bottom-left
    int row = n - 1;
    int col = 0;

    int count = 0;

    while (row >= 0 && col < n) {

        if (matrix[row][col] <= target) {

            /*
             * Why count += row + 1 ?
             *
             * Since matrix[row][col] <= target,
             * everything ABOVE it in the same column
             * is also <= target (column is sorted).
             *
             * Number of such elements:
             * 0 ... row  => row + 1 elements
             */
            count += row + 1;

            /*
             * Why move RIGHT ?
             *
             * Current column is fully processed.
             * We already counted all valid elements
             * in this column up to 'row'.
             *
             * Move right to check larger values.
             */
            col++;

        } else {

            /*
             * Why move UP ?
             *
             * Current value is too large.
             *
             * Everything to the right is even larger
             * (row is sorted), so they are useless.
             *
             * Move up to find smaller values.
             */
            row--;
        }
    }

    return count;
}
}


             MINHEAP APPROACH
class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        /*
         * Min Heap stores:
         * [value, row, col]
         *
         * Heap is sorted by value (smallest on top).
         */
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        /*
         * Each row is already sorted.
         *
         * Start by inserting the first element
         * from every row into the heap.
         *
         * Example:
         * [1,5,9]
         * [10,11,13]
         * [12,13,15]
         *
         * Heap initially:
         * 1, 10, 12
         */
        for (int row = 0; row < n; row++) {
            minHeap.offer(new int[]{matrix[row][0], row, 0});
        }

        int answer = 0;

        /*
         * Pop exactly k times.
         *
         * The kth popped element
         * will be the kth smallest.
         */
        for (int i = 0; i < k; i++) {

            // Smallest available element
            int[] current = minHeap.poll();

            answer = current[0];

            int row = current[1];
            int col = current[2];

            /*
             * Why insert next element from same row?
             *
             * Example:
             * Row = [1,5,9]
             *
             * After removing 1,
             * the next candidate from this row is 5.
             *
             * This is exactly like merging
             * multiple sorted lists.
             */
            if (col + 1 < n) {

                minHeap.offer(
                        new int[]{
                                matrix[row][col + 1], // next value
                                row,                  // same row
                                col + 1               // next column
                        }
                );
            }
        }

        // kth popped element
        return answer;
    }
}