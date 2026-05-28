Pattern Recognition: 

Brute Force Approach: Store all elements in an array/list and insert new element whenever add(val) is called.
Sort entire array in descending order after every insertion. Return element at index k-1 as kth largest.
Time: O(n log n) per add operation, Space: O(n)

Optimal Approach (Min Heap): Maintain a Min Heap of size k containing only top k largest elements.
Insert new element into heap; if heap size exceeds k, remove smallest element using poll().
Root of Min Heap always represents kth largest element.
Time: O(log k) per add operation, Space: O(k)

class KthLargest {

    // Min Heap
    // Stores only the top k largest elements
    PriorityQueue<Integer> minHeap;

    // Stores value of k
    int k;

    // Constructor
    public KthLargest(int k, int[] nums) {

        // Initialize k
        this.k = k;

        // Create Min Heap
        // By default, PriorityQueue in Java is Min Heap
        minHeap = new PriorityQueue<>();

        // Process all initial elements
        for (int num : nums) {

            // Add element into heap
            // Element first goes at end internally
            // Then heapify/bubble-up happens automatically
            minHeap.offer(num);

            // If heap size becomes greater than k
            // remove smallest element
            // because we only need top k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    // Adds new value into stream
    public int add(int val) {

        // Insert new element into heap
        minHeap.offer(val);

        // If heap size exceeds k
        // remove smallest element
        // smallest element is useless for top k largest
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Root of Min Heap
        // = smallest among top k largest
        // = kth largest element
        return minHeap.peek();
    }
}