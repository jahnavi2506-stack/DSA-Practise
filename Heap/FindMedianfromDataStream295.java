Pattern Recognition: Two Heaps (Max Heap + Min Heap).

Brute Force Approach
Store all numbers in a list and sort the entire list whenever findMedian() is called.
After sorting, return the middle element (odd size) or average of the two middle elements (even size).
Simple to implement but repeatedly sorting is expensive.
Time Complexity: addNum() - O(1), findMedian() - O(n log n)
Space Complexity: O(n)

Optimal Approach (Two Heaps)
Use a Max Heap for the left half and a Min Heap for the right half.
Maintain: all left elements ≤ all right elements and heap size difference ≤ 1.
Median = top of larger heap (odd count) or average of both heap tops (even count).
Time Complexity: addNum() - O(log n), findMedian() - O(1)
Space Complexity: O(n)

Rebalancing:
If a heap becomes larger by more than 1 element, move its top element to the other heap.
Reason: Median requires both halves to have equal size (or differ by at most 1).

1. Insert into left or right heap based on left.peek().
2. Rebalance if size difference exceeds 1.
3. Maintain left <= right and size difference <= 1.

Equal sizes   → average of both heap tops.
Unequal sizes → top of larger heap.

class MedianFinder {

    // Max Heap -> stores smaller half
    private PriorityQueue<Integer> left;

    // Min Heap -> stores larger half
    private PriorityQueue<Integer> right;

    public MedianFinder() {

        // Max Heap
        left = new PriorityQueue<>((a, b) -> b - a);

        // Min Heap
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Insert into appropriate heap
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Step 2: Rebalance heaps if size difference > 1
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }

        if (right.size() > left.size() + 1) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        // Even number of elements
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }

        // Odd number of elements
        return left.size() > right.size()
                ? left.peek()
                : right.peek();
    }
}