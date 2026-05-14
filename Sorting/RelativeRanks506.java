Pattern Recognition:- Sorting + index mapping

# Brute Force Approach:
Repeatedly scan the array to find the maximum unvisited score and assign ranks one by one (`Gold`, `Silver`, `Bronze`, then `"4"`, `"5"`...).
Use a visited[] array to avoid selecting the same athlete again and an `answer[]` array to store results in original positions.
Time Complexity:O(n²) because for every rank we scan the entire array again.
Space Complexity: O(n) for `visited[]` and answer[].

Optimal Approach: Store each athlete as (score, originalIndex) so sorting does not lose original positions.
Sort pairs in descending order of score, then assign medals/ranks based on sorted position and place them at answer[originalIndex].
Time Complexity: O(n log n) due to sorting.
Space Complexity: O(n) for pair storage and answer array.

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        // Final answer array
        String[] answer = new String[n];

        // pair[i][0] = score
        // pair[i][1] = original index
        int[][] pair = new int[n][2];

        // Store score with original index
        for (int i = 0; i < n; i++) {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }

        // Sort in descending order based on score
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        // Traverse sorted array and assign ranks
        for (int i = 0; i < n; i++) {

            // Original index of current athlete
            int originalIndex = pair[i][1];

            // Assign medals for top 3
            if (i == 0) {
                answer[originalIndex] = "Gold Medal";
            }
            else if (i == 1) {
                answer[originalIndex] = "Silver Medal";
            }
            else if (i == 2) {
                answer[originalIndex] = "Bronze Medal";
            }

            // Remaining athletes get numeric rank
            else {
                answer[originalIndex] = String.valueOf(i + 1);
            }
        }

        return answer;
    }
}