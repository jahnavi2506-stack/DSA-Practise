Pattern Recognition: Two-pointers

Brute Force Approach: Try every possible pair of lines (i, j).
Calculate area = (j - i) * min(height[i], height[j]).
Keep track of the maximum area found. Time: O(n²),Space: O(1)

Optimal Approach (Two Pointers): Place one pointer at the start and one at the end to get maximum width.
Calculate the area and update the maximum area.
Move the pointer with the smaller height and repeat until pointers meet. Time: O(n), Space: O(1)

class Solution {
    public int maxArea(int[] height) {

        // Two pointers at both ends
        int left = 0;
        int right = height.length - 1;

        // Stores maximum area found
        int maxArea = 0;

        while (left < right) {

            // Width between the two lines
            int width = right - left;

            // Smaller height determines water level
            int h = Math.min(height[left], height[right]);

            // Current area
            int area = width * h;

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            // Move the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}