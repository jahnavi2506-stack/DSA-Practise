Pattern Recognition: Binary Search on Answer Space

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        // Minimum possible divisor
        int low = 1;

        // Maximum possible divisor = max element in array
        int high = 0;

        // Find maximum element
        for (int num : nums) {
            high = Math.max(high, num);
        }

        // Store final answer
        int ans = high;

        // Binary Search on Answer Space
        while (low <= high) {

            // Middle divisor
            int mid = low + (high - low) / 2;

            // Calculate total sum after division
            int sum = 0;

            for (int num : nums) {

                // Ceiling division:
                // ceil(num / mid)
                sum += (num + mid - 1) / mid;
            }

            // VALID divisor
            if (sum <= threshold) {

                // Store possible answer
                ans = mid;

                // Try to find smaller valid divisor
                high = mid - 1;
            }

            // INVALID divisor
            else {

                // Need larger divisor to reduce sum
                low = mid + 1;
            }
        }

        return ans;
    }
}

Small divisor - large sum
Large divisor - small sum
VALID - try smaller answer - move high
INVALID - need bigger answer - move low