Pattern Recognition: Frequency Array + Greedy.

Brute Force (Backtracking)
Try placing every available character at each position, ensuring it is different from the previously placed character.
Recursively build all possible valid arrangements until a complete string is formed.
If no valid arrangement exists, return "".

Time Complexity: O(n!)
Space Complexity: O(n) (recursion stack)

2. Heap (Priority Queue) + Greedy
Count frequencies and store characters in a max heap based on frequency.
Repeatedly pick the highest-frequency character, append it, and keep it aside for one turn to avoid adjacent duplicates.
Reinsert the previously used character (if frequency remains) back into the heap and continue.

Time Complexity: O(n log k)
Space Complexity: O(k)

k = number of distinct characters (at most 26 here)

3. Greedy (Frequency Array + Even/Odd Filling)
Place the most frequent character first at indices 0, 2, 4, ... to maximize separation.
After exhausting it, place the remaining characters in the remaining even positions and then odd positions.
If the maximum frequency exceeds (n+1)/2, return "".

Time Complexity: O(n + k) ≈ O(n)
Space Complexity: O(k)

                              Heap + Greedy
class Solution {
    public String reorganizeString(String s) {

        // Step 1: Count frequency of each character
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Max Heap
        // Stores: [frequency, characterIndex]
        // Example: [3, 0] => a appears 3 times
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Step 3: Insert all characters with frequency > 0 into heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{freq[i], i});
            }
        }

        // Stores the final rearranged string
        StringBuilder result = new StringBuilder();

        // Stores the previously used character temporarily
        // so it cannot be used in the immediate next position
        int[] prev = null;

        // Step 4: Build answer greedily
        while (!maxHeap.isEmpty()) {

            // Get character with highest remaining frequency
            int[] current = maxHeap.poll();

            // Append character to answer
            result.append((char) (current[1] + 'a'));

            // One occurrence has been used
            current[0]--;

            // Reinsert previous character back into heap
            // (if it still has remaining frequency)
            if (prev != null && prev[0] > 0) {
                maxHeap.offer(prev);
            }

            // Hold current character aside for one turn
            prev = current;
        }

        // Step 5: Validation
        // If answer length is smaller than original length,
        // some characters could not be placed.
        if (result.length() != s.length()) {
            return "";
        }

        return result.toString();
    }
}