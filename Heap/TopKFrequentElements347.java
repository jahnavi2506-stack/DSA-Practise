Pattern Recognition: 
Primary Pattern: HashMap + Min Heap
Follow-up Pattern: HashMap + Bucket Sort

nums = [1,1,2,2,3]
k = 1
There is a tie between 1 and 2. Since the original problem guarantees a unique answer, this case won't occur. 
If ties were allowed, we would need clarification on how to break them

Brute Force Approach: Use a HashMap to count frequencies of all elements.
Sort the unique elements based on their frequencies in descending order.
Return the first k elements after sorting.
Time: O(n + m log m), n = array size m = number of unique elements ,Space: O(m)

Optimal Approach (Bucket Sort): Count frequencies using a HashMap.
Create buckets where index = frequency and store numbers having that frequency.
Traverse buckets from highest frequency to lowest until k elements are collected. Time: O(n), Space: O(n)

Alternative Optimal Approach (Min Heap): Count frequencies using a HashMap.
Maintain a Min Heap of size k based on frequency.
Remove the smallest frequency whenever heap size exceeds k. Time: O(n log k), Space: O(m + k)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Store frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            // If num exists, increment frequency
            // Otherwise start with frequency 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*
         * Step 2: Create a Min Heap
         *
         * Each element in heap is:
         * [number, frequency]
         *
         * Heap is ordered by frequency.
         * Smallest frequency stays at the top.
         */
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Step 3: Process all entries from frequency map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int number = entry.getKey();
            int frequency = entry.getValue();

            // Add [number, frequency] into heap
            pq.offer(new int[]{number, frequency});

            /*
             * Keep only k elements in heap.
             * If heap size becomes greater than k,
             * remove the element with smallest frequency.
             */
            if (pq.size() > k) {
                pq.poll();
            }
        }

        /*
         * After processing all numbers,
         * heap contains only the k most frequent elements.
         */

        // Step 4: Create result array
        int[] result = new int[k];

        /*
         * Extract elements from heap.
         * pq.poll()[0] gives the number.
         * pq.poll()[1] would give its frequency.
         */
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}