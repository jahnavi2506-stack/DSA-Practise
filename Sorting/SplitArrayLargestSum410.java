Pattern Recognition: "Binary Search on Answer Space", Largest sum should be minimized [minimize(maximum)]

Brute Force: Try every possible way to split array into `k` contiguous subarrays.
For each split, calculate sum of every subarray and take the maximum sum.
Return the minimum among all such maximum sums.
Time: Exponential, Space: O(k) recursion stack

Optimal Approach (Binary Search on Answer + Greedy): Binary search on possible maximum subarray sum from `max(nums)` to `sum(nums)`.
For each `mid`, greedily check how many subarrays are needed if no subarray sum exceeds `mid`.
If required subarrays ≤ `k`, try smaller answer; otherwise increase answer.
Time: O(n * log(sum(nums))), Space: O(1)

class Solution {

    public int splitArray(int[] nums, int k) {

        // Minimum possible answer:
        // Largest element in array
        int low = 0;

        // Maximum possible answer:
        // Sum of all elements
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        // Binary Search on Answer
        while (low < high) {

            // Mid = candidate maximum subarray sum
            int mid = low + (high - low) / 2;

            // Count how many subarrays are needed
            // if maximum allowed sum is mid
            int subarrays = 1;

            // Current subarray sum
            int currentSum = 0;

            for (int num : nums) {

                // If adding current element exceeds mid,
                // create new subarray
                if (currentSum + num > mid) {

                    subarrays++;

                    // Start new subarray with current element
                    currentSum = num;
                } else {

                    // Continue adding to current subarray
                    currentSum += num;
                }
            }

            // If we can split into at most k subarrays,
            // try finding smaller valid answer
            if (subarrays <= k) {
                high = mid;
            }

            // Otherwise increase allowed maximum sum
            else {
                low = mid + 1;
            }
        }

        // low == high = minimized largest sum
        return low;
    }
}

