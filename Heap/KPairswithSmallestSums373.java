Pattern Recognition: Priority Queue (Min Heap).

Brute Force: Generate all possible pairs (nums1[i], nums2[j]). Store them and sort by their sum.
Return the first k pairs. Time: O(n × m × log(n × m)), Space: O(n × m)

Optimal (Min Heap / K-way Merge): Insert the first pair of each row (i, 0) into a min heap.
Pop the smallest pair, add it to the answer.
Push the next pair from the same row (i, j+1) and repeat k times. Time: O(k log min(n, k)), Space: O(min(n, k))

Algorithm:
1. Put head of each row into heap.
2. Pop smallest.
3. Add to answer.
4. Push next node of same row.
5. Repeat k times.

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // Stores final answer
        List<List<Integer>> answer = new ArrayList<>();

        // Min Heap: [sum, rowIndex, colIndex]
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // We only need at most k rows initially
        int rows = Math.min(nums1.length, k);

        // Insert first element (column 0) of each row
        for (int i = 0; i < rows; i++) {
            minHeap.offer(new int[]{
                    nums1[i] + nums2[0], // pair sum
                    i,                   // row index in nums1
                    0                    // column index in nums2
            });
        }

        // Extract k smallest pairs
        while (k > 0 && !minHeap.isEmpty()) {

            // Get smallest pair
            int[] current = minHeap.poll();

            int i = current[1]; // row index
            int j = current[2]; // column index

            // Add actual pair to answer
            answer.add(Arrays.asList(nums1[i], nums2[j]));

            // Push next element from the same row
            // Move from (i,j) -> (i,j+1)
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{
                        nums1[i] + nums2[j + 1], // new sum
                        i,                       // same row
                        j + 1                    // next column
                });
            }

            k--;
        }

        return answer;
    }
}