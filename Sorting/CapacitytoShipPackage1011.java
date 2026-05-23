Pattern Recognition: Binary Search on Answer Space

Brute Force: Try every capacity from `max(weights)` to `sum(weights)`.
For each capacity, simulate shipping in order and count required days.
Return the first capacity that ships all packages within given days.
Time Complexity: `O(n × (sum - max))`, Space Complexity: `O(1)`

Optimal: Binary search on capacity range `[max(weights), sum(weights)]`.
For each mid capacity, simulate shipment and check if packages can be shipped within given days.
If valid - search smaller capacity, else - search larger capacity.
Time Complexity: `O(n × log(sum - max))`, Space Complexity: `O(1)`

class Solution {

    public int shipWithinDays(int[] weights, int days) {

        // Minimum possible capacity cannot be smaller
        // than the heaviest package
        int low = 0;

        // Maximum possible capacity is shipping
        // all packages in one day
        int high = 0;

        // Find:
        // low  -> max element
        // high -> sum of array
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        // Store minimum valid answer
        int ans = high;

        // Binary Search on Answer
        while (low <= high) {

            // Safe mid calculation
            int mid = low + (high - low) / 2;

            // Check if current capacity is valid
            if (canShip(weights, days, mid)) {

                // Store current valid capacity
                ans = mid;

                // Try finding smaller valid capacity
                high = mid - 1;

            } else {

                // Capacity too small
                // Need larger capacity
                low = mid + 1;
            }
        }

        return ans;
    }

    // Helper function to check whether
    // shipping is possible with given capacity
    private boolean canShip(int[] weights, int days, int capacity) {

        // Shipment starts from Day 1
        int daysUsed = 1;

        // Current load carried in current day
        int currentLoad = 0;

        // Traverse all packages in order
        for (int weight : weights) {

            // If adding current package exceeds capacity
            if (currentLoad + weight > capacity) {

                // Start a new day
                daysUsed++;

                // Current package becomes first
                // package of new day
                currentLoad = weight;

            } else {

                // Add package to current day
                currentLoad += weight;
            }
        }

        // Valid if shipment completes
        // within allowed days
        return daysUsed <= days;
    }
}
