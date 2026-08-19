Pattern Recognition: Running Sum / Prefix Sum

Brute Force Approach: Calculate every altitude separately by summing all previous gains for each point.
Compare each calculated altitude with the maximum.
This repeats calculations unnecessarily. Time: O(n²), Space: O(1)

Optimal Approach: Start altitude = 0 and maxAltitude = 0.
For every gain, update altitude += gain[i] and update the maximum.
Return maxAltitude. Time: O(n),Space: O(1)

class Solution {
    public int largestAltitude(int[] gain) {

        // Starting altitude is 0
        int altitude = 0;

        // Since we start at altitude 0,
        // the highest altitude is initially 0
        int maxAltitude = 0;

        // Traverse through every altitude gain/loss
        for (int i = 0; i < gain.length; i++) {

            // Update current altitude
            altitude = altitude + gain[i];

            // Keep track of the highest altitude reached
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        // Return the highest altitude
        return maxAltitude;
    }
}
