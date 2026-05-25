Pattern Recognition: Binary Search on Answer Space

Brute Force: Try every possible day from minimum bloom day to maximum bloom day.
For each day, scan the array and count whether `m` bouquets of `k` adjacent bloomed flowers can be formed.
Time Complexity: `O((maxDay - minDay) * n)` , Space Complexity: `O(1)`

Optimal: Binary search on days because bouquet formation follows monotonic behavior (`invalid → valid`).
For every mid day, linearly check if at least `m` bouquets can be formed using consecutive bloomed flowers.
Time Complexity: `O(n * log(maxDay - minDay))` , Space Complexity: `O(1)`


class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        // Total flowers available
        int n = bloomDay.length;

        // Edge Case:
        // If required flowers > available flowers
        // impossible to make bouquets
        if ((long) m * k > n) {
            return -1;
        }

        // Binary Search Range
        // low = minimum bloom day
        // high = maximum bloom day

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        // Store minimum valid answer
        int ans = -1;

        // Binary Search on Days
        while (low <= high) {

            // Mid day to check
            int mid = low + (high - low) / 2;

            // Check if we can make m bouquets on this day
            if (canMakeBouquets(bloomDay, mid, m, k)) {

                // mid is a possible answer
                ans = mid;

                // Try to find smaller valid day
                high = mid - 1;
            } else {

                // Not enough bouquets
                // Need more flowers to bloom
                low = mid + 1;
            }
        }

        return ans;
    }

    // Helper function
    // Checks if we can make m bouquets on 'day'
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {

        // Count consecutive bloomed flowers
        int flowers = 0;

        // Count bouquets formed
        int bouquets = 0;

        for (int bloom : bloomDay) {

            // Flower bloomed on or before current day
            if (bloom <= day) {

                flowers++;

                // Enough adjacent flowers for one bouquet
                if (flowers == k) {

                    bouquets++;

                    // Reset because flowers can be used only once
                    flowers = 0;
                }

            } else {

                // Adjacency breaks
                flowers = 0;
            }
        }

        // Return true if enough bouquets formed
        return bouquets >= m;
    }
}