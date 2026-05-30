Pattern Recognition: HashMap + Min Heap

Brute Force Approach: Use a HashMap to count the frequency of each word.
Store all (word, frequency) pairs in a list and sort the entire list, Higher frequency first
If frequency ties, lexicographically smaller word first. Take the first k words from the sorted list.
Time  : O(n + m log m), Space : O(m)
n = total words
m = unique words

Optimal Approach (Min Heap): Use a HashMap to count frequencies.
Maintain a Min Heap of size k: Lower frequency is worse. If tie, lexicographically larger word is worse
Insert each unique word into the heap; if size exceeds k, remove the worst word. Reverse extracted result at the end.
Time  : O(n + m log k), Space : O(m + k)

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min Heap of size k
        // Priority:
        // 1. Smaller frequency = higher priority for removal
        // 2. If frequencies are same,
        //    lexicographically larger word = higher priority for removal
        //
        // Why?
        // Because final answer needs:
        // Higher frequency first
        // If tie -> lexicographically smaller first
        //
        // So inside min heap we keep the WORST candidate at the top.
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (a, b) -> {

                int freqA = freqMap.get(a);
                int freqB = freqMap.get(b);

                // Smaller frequency should come first
                if (freqA != freqB) {
                    return freqA - freqB;
                }

                // Same frequency:
                // lexicographically larger word is worse
                // and should come first in min heap
                return b.compareTo(a);
            }
        );

        // Step 3: Keep only top k words in heap
        for (String word : freqMap.keySet()) {

            minHeap.offer(word);

            // Remove worst candidate when size exceeds k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract elements
        List<String> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        // Current order is worst -> best
        // Reverse to get:
        // highest frequency first
        // lexicographically smaller first for ties
        Collections.reverse(result);

        return result;
    }
}