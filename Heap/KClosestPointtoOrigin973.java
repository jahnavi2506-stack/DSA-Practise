Pattern Recognition: Heap/Priority Queue

Because min heap keeps smallest element at top.
But we need quick removal of largest distance among current k closest points.
So max heap is required.

Brute Force Approach (Sorting)
Compute squared distance for each point, sort points based on distance, and return first k points.
Time: O(nlogn) due to sorting, Space: O(n) for storing distances

Optimal Approach (Max Heap / Priority Queue)
Process each point and compute squared distance.
Insert (distance, point) into a MAX heap; if heap size exceeds k, remove heap top (farthest point)
Continue until all points are processed. Time: O(nlogk) due to heap operations, Space: O(k) for heap

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        // MAX HEAP based on distance
        // Heap element format:
        // [distance, x, y]
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Traverse all points
        for (int[] point : points) {

            int x = point[0];
            int y = point[1];

            // Calculate squared distance from origin
            // We use squared distance to avoid unnecessary sqrt calculation
            int distance = (x * x) + (y * y);

            // Insert into heap
            maxHeap.offer(new int[]{distance, x, y});

            // Maintain heap size = k
            // Remove farthest point if size exceeds k
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Result array to store k closest points
        int[][] result = new int[k][2];

        // Extract elements from heap
        // Heap contains exactly k closest points
        for (int i = 0; i < k; i++) {

            int[] current = maxHeap.poll();

            // Store only x and y
            result[i][0] = current[1];
            result[i][1] = current[2];
        }

        return result;
    }
}
result is a 2D array
k = number of rows → because we need to store k points
2 = number of columns → because each point has exactly 2 values: [x, y]

