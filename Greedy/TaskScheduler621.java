Pattern Recognition: Frequency Array + Greedy + Mathematical Counting

Brute Force Approach:
Simulate the CPU interval by interval;at each time unit,execute the available task with the highest remaining frequency,otherwise insert an idle.
Track each task's remaining count and the next time it can be executed (cooldown expiry).
Time Complexity: O(T x 26), where T = total intervals (tasks + idles), worst case O(N²). Space Complexity: O(26) = O(1).

Heap Approach: Simulates task scheduling step by step. Builds the actual order. Time: O(N log 26) ≈ O(N).

Greedy Formula: Observes that the most frequent task determines the minimum possible schedule length.
Directly calculates the answer using frequencies. Time: O(N), Space: O(1) (26 letters).
Interview Rule
Need actual schedule/order - Use Heap.
Need only minimum intervals/count - Use Greedy Formula.
Here, since only the minimum number of intervals is required, the greedy mathematical solution is simpler and more optimal.

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count frequency of each task (A-Z)
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find the maximum frequency
        // This task becomes the bottleneck because it needs
        // the most cooling gaps between its occurrences.
        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Step 3: Count how many tasks have max frequency
        // Example:
        // A A A
        // B B B
        // maxFreq = 3, maxCount = 2
        int maxCount = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        // Step 4: Calculate minimum slots required based on cooling
        //
        // Think of the most frequent task forming blocks:
        //
        // A _ _ A _ _ A
        //
        // Number of blocks = maxFreq - 1
        // Size of each block = n + 1
        //
        // If multiple tasks have max frequency,
        // they occupy the last positions together.
        int requiredSlots =
                (maxFreq - 1) * (n + 1) + maxCount;

        // Step 5:
        // If other tasks are enough to fill all idle slots,
        // answer becomes simply total number of tasks.
        //
        // Example:
        // A A A
        // B B B
        // C C C
        // D D D
        //
        // No idle time needed.
        return Math.max(tasks.length, requiredSlots);
    }
}