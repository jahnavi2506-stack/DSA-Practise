Pattern Recognition: Greedy + Max Heap

Brute Force:: For every upward climb, try both choices: bricks or ladder.
Explore all possible allocations recursively.
Time: O(2^n), Space: O(n) recursion stack.

Optimal (Greedy + Min Heap): Push every positive climb into a min heap.
If heap size exceeds ladders, remove the smallest climb and pay bricks for it.
If bricks become negative, return the current building index.
Time: O(n log ladders) (often written as O(n log n) in worst case), Space: O(ladders)

A ladder can cover any climb, whether it's 1 or 1000, at the same cost of one ladder. Bricks, however, are consumed proportional to the climb 
height. Therefore, to minimize brick usage, ladders should always be reserved for the largest climbs. Whenever the number of climbs assigned 
ladders exceeds the available ladders, I remove the smallest climb from the heap and pay bricks for it, because that's the cheapest climb to 
convert from ladder usage to brick usage.

We use a min heap because whenever the number of climbs assigned ladders exceeds the available ladders, we want to convert the cheapest climb to 
bricks. The cheapest climb is the smallest climb. A min heap gives the smallest climb in O(log n) time, allowing ladders to remain reserved for
the largest climbs, which minimizes total brick usage

class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        // Min Heap stores all positive climbs encountered so far.
        // Idea:
        // - Assume every positive climb uses a ladder.
        // - If ladder assignments exceed available ladders,
        //   convert the smallest climb to bricks.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Traverse all adjacent building pairs
        for (int i = 0; i < heights.length - 1; i++) {

            // Calculate height difference between current and next building
            int climb = heights[i + 1] - heights[i];

            // No resources needed for downhill or equal height
            if (climb <= 0) {
                continue;
            }

            // Tentatively assign a ladder to this climb
            minHeap.offer(climb);

            // If more climbs are using ladders than ladders available,
            // remove the smallest climb and pay bricks for it
            if (minHeap.size() > ladders) {

                // Smallest climb is cheapest to pay with bricks
                bricks -= minHeap.poll();
            }

            // If bricks become negative,
            // we cannot complete the jump from i to i+1
            if (bricks < 0) {
                return i;
            }
        }

        // Successfully reached the last building
        return heights.length - 1;
    }
}