Pattern Recognition: Maximum

Brute Force Approach: For each kid, add extraCandies and calculate their new candy count.
Compare this new count with every other kid's candy count to check if it is the greatest.
If no kid has more candies, mark true; otherwise false. Time: O(n²), Space: O(1) (excluding output array)

Optimal Approach: Find the maximum number of candies among all kids.
For each kid, check if candies[i] + extraCandies >= maxCandy.
If yes, add true to the result; otherwise add false. Time: O(n), Space: O(1) (excluding output array)

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // Store the maximum candies any kid currently has
        int maxCandy = 0;

        // Find the maximum value in the candies array
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }

        // List to store the result (true/false for each kid)
        List<Boolean> result = new ArrayList<>();

        // Check each kid
        for (int candy : candies) {

            // If this kid gets all extra candies,
            // will they have at least as many candies as the current maximum?
            if (candy + extraCandies >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        // Return the boolean result list
        return result;
    }
}