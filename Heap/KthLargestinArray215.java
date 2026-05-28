Pattern Recognition: Priority Queue (Min Heap) is ideal for finding kth largest element in an array.

Brute Force — Sorting: Sort the array in ascending order and return element at index n - k.
We fully sort the array even though only one ranked element is needed. Simple and easy, but does unnecessary work.
Time: O(nlogn), Space Complexity: O(1) to O(logn)

Optimal — Min Heap: Maintain a min heap of size k containing the k largest elements seen so far.
If heap size exceeds k, remove the smallest element. Heap top finally represents the kth largest element.
Time Complexity: O(nlogk), Space Complexity: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Traverse all elements
        for (int num : nums) {

            // Add current element into heap
            minHeap.offer(num);

            // Maintain only k largest elements
            // If size exceeds k, remove smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Heap top contains kth largest element
        return minHeap.peek();
    }
}
k largest-  Min Heap 
k smallest- Max Heap 
