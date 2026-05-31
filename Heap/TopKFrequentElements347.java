Pattern Recognition: 
Primary Pattern: HashMap + Min Heap
Follow-up Pattern: HashMap + Bucket Sort

nums = [1,1,2,2,3]
k = 1
There is a tie between 1 and 2. Since the original problem guarantees a unique answer, this case won't occur. 
If ties were allowed, we would need clarification on how to break them

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Step 3: Keep only top k frequent elements
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {

            int number = entry.getKey();
            int frequency = entry.getValue();

            minHeap.offer(new int[]{number, frequency});

            // Remove smallest frequency if size exceeds k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract answer
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }
}