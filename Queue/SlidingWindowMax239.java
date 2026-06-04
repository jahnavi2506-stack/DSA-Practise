BruteForce:- For every window of size k, you scan all k elements and find max
Then move window by 1 and repeat the same scan again
For each index i, compute max of subarray nums[i → i+k-1] by scanning all k elements
Time = O(n·k), Space = O(1) (excluding output)

Optimal:- Use a monotonic decreasing deque to store useful elements indices
Time = O(n), Space = O(k)

Only keep elements that have a chance to become maximum in the future
Discard everything that is “blocked” by a bigger element coming later.

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove out-of-window indices from front
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Maintain decreasing order (remove smaller from back)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Store result once window is formed
            if (i >= k - 1) {
                result[idx++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}

Heap: Gives max in O(log k) for every insertion/removal, so total complexity becomes O(n log k).
Deque: Maintains elements in decreasing order, so each element is added and removed at most once, giving O(n) total time.
Therefore: We use deque because it exploits the sliding-window property and achieves O(n) instead of O(n log k) while still giving
the maximum in O(1) from the front.