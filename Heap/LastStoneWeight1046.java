Pattern Recognition: Heap/Priority Queue

Brute Force Approach: Repeatedly sort the array and pick the two largest stones from the end.
Smash them, remove both stones, and insert the difference if non-zero. Continue until at most one stone remains.
Time: O(n^2logn) due to repeated sorting, Space: O(1) or O(n) depending on sorting implementation

Optimal Approach (Max Heap / Priority Queue): Store all stones in a Max Heap so largest stone is always available at top.
Repeatedly remove two largest stones, smash them, and insert difference if non-zero.
Continue until heap size becomes 0 or 1. Time: O(nlogn), Space: O(n)

class Solution {

    public int lastStoneWeight(int[] stones) {

        // Max Heap
        // By default Java PriorityQueue is Min Heap,
        // so we use Collections.reverseOrder()
        // to convert it into Max Heap.
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Insert all stones into max heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Continue until only one (or zero) stone remains
        while (maxHeap.size() > 1) {

            // Remove largest stone
            int first = maxHeap.poll();

            // Remove second largest stone
            int second = maxHeap.poll();

            // If both stones are different,
            // insert the remaining difference back
            if (first != second) {

                // Larger - Smaller
                maxHeap.offer(first - second);
            }

            // If both are equal:
            // both destroyed
            // do nothing
        }

        // If heap becomes empty,
        // return 0
        if (maxHeap.isEmpty()) {
            return 0;
        }

        // Otherwise return last remaining stone
        return maxHeap.peek();
    }
}