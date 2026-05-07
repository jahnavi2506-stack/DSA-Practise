Pattern Recognition:- 

Variable Sliding Window
Goal - Longest (maximum size) valid subarray

Brute Force:-
Generate all subarrays using two loops (start i, end j), and maintain running max and min while extending j.
For each subarray, check if max - min ≤ limit and track maximum length. Time: O(n²), Space: O(1)
Optimal :-
Use variable sliding window with two pointers (left, right) and maintain max & min using monotonic deques.
Expand window, and if max - min > limit, shrink from left while updating deques. Time: O(n), Space: O(n)

In the max deque, we remove all smaller elements from the back because 
they can never become the maximum in the current or any future window once a larger element has arrived.

This problem asks for the longest contiguous subarray where the difference between the maximum and minimum elements is within a given limit.
A brute force approach would check all subarrays and compute max and min, resulting in O(n²) time.
To optimize, I use a variable sliding window along with two monotonic deques—one to maintain the maximum and one for the minimum. 
As I expand the window, I update these deques by removing useless elements. If the condition max - min > limit is violated, 
I shrink the window from the left and update the deques accordingly.
Since each element is added and removed at most once, the overall time complexity is O(n).


class Solution {
    public int longestSubarray(int[] nums, int limit) {

        // Deque to maintain decreasing order (max at front)
        Deque<Integer> maxDeque = new ArrayDeque<>();

        // Deque to maintain increasing order (min at front)
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int maxLength = 0;

        // Right pointer expands the window
        for (int right = 0; right < nums.length; right++) {

            // Step 1: Maintain maxDeque (decreasing)
            // Remove all smaller elements from back
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right); // store index

            // Step 2: Maintain minDeque (increasing)
            // Remove all larger elements from back
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right); // store index

            // Step 3: Shrink window if invalid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {

                // If element going out is max → remove it
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                // If element going out is min → remove it
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++; // shrink window
            }

            // Step 4: Update answer (valid window)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}