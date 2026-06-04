Pattern Recognition: Two Heaps + Lazy Deletion

Brute Force Approach: For every sliding window of size k, copy its elements.
Sort the window and find the median from the sorted array. Repeat for all windows.
Time: O((n - k + 1) * k log k) ≈ O(n * k log k), Space: O(k)

Optimal Approach: Use a Max Heap for the smaller half and a Min Heap for the larger half.
As the window slides, add the incoming element and lazily remove the outgoing element using a HashMap.
Keep heaps balanced and obtain the median from heap tops. Time: O(n log k), Space: O(k)

class Solution {

    // Max Heap -> stores smaller half of numbers
    private PriorityQueue<Integer> small;

    // Min Heap -> stores larger half of numbers
    private PriorityQueue<Integer> large;

    // Lazy deletion map
    // Key = number to be removed later
    // Value = how many times it should be removed
    private Map<Integer, Integer> delayed;

    // Valid element counts (excluding delayed elements)
    private int smallSize;
    private int largeSize;

    private int k;

    public double[] medianSlidingWindow(int[] nums, int k) {

        this.k = k;

        // Max Heap
        small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // Min Heap
        large = new PriorityQueue<>();

        delayed = new HashMap<>();

        smallSize = 0;
        largeSize = 0;

        int n = nums.length;

        // Number of windows = n - k + 1
        double[] result = new double[n - k + 1];

        // Build first window
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }

        // Median of first window
        result[0] = getMedian();

        // Slide window
        for (int i = k; i < n; i++) {

            // New element enters window
            addNum(nums[i]);

            // Old element leaves window
            removeNum(nums[i - k]);

            // Store current window median
            result[i - k + 1] = getMedian();
        }

        return result;
    }

    // Add a number into one of the heaps
    private void addNum(int num) {

        // If number belongs to smaller half
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        }

        // Otherwise put in larger half
        else {
            large.offer(num);
            largeSize++;
        }

        // Maintain heap balance
        balanceHeaps();
    }

    // Remove a number using lazy deletion
    private void removeNum(int num) {

        // Mark number for future deletion
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        // Decide which heap logically contains num
        if (num <= small.peek()) {

            smallSize--;

            // If num is already on top,
            // remove immediately
            if (num == small.peek()) {
                prune(small);
            }

        } else {

            largeSize--;

            // If num is already on top,
            // remove immediately
            if (!large.isEmpty() && num == large.peek()) {
                prune(large);
            }
        }

        // Restore heap size property
        balanceHeaps();
    }

    // Keep heaps balanced
    private void balanceHeaps() {

        // small can have at most 1 extra element

        // Too many elements in small
        if (smallSize > largeSize + 1) {

            large.offer(small.poll());

            smallSize--;
            largeSize++;

            // Remove invalid top elements
            prune(small);
        }

        // Too many elements in large
        else if (smallSize < largeSize) {

            small.offer(large.poll());

            smallSize++;
            largeSize--;

            // Remove invalid top elements
            prune(large);
        }
    }

    // Remove delayed elements from heap top
    private void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            // Top element is valid
            if (!delayed.containsKey(num)) {
                break;
            }

            // Reduce delayed frequency
            int freq = delayed.get(num);

            if (freq == 1) {
                delayed.remove(num);
            } else {
                delayed.put(num, freq - 1);
            }

            // Physically remove invalid element
            heap.poll();
        }
    }

    // Compute current median
    private double getMedian() {

        // Odd window size
        if ((k & 1) == 1) {
            return (double) small.peek();
        }

        // Even window size
        // Use long to avoid integer overflow
        return ((long) small.peek() + (long) large.peek()) / 2.0;
    }
}