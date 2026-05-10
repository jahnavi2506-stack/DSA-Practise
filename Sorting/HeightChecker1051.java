Pattern Recognition:- Sorting + Frequency Counting (Counting Sort pattern)

Brute Force:-
Copy array - sort it - compare original and sorted arrays index by index to count mismatches.
Time: O(nlogn)
Space: O(n)

Optimal Approach:-
Use frequency array to generate sorted order dynamically without actual sorting, compare directly with original array while traversing frequencies.
Time: O(n + range) where range is constant (100 in this case)
Space: O(1)

The constraints show that heights[i] lies only between 1 and 100, which is a very small bounded range. 
Instead of using comparison sorting in O(n log n), we can count frequencies and generate the sorted order in linear time. 
This reduces time complexity to O(n) with constant extra space.

class Solution {
    public int heightChecker(int[] heights) {

        // Frequency array to store count of heights from 1 to 100
        int[] freq = new int[101];

        // Step 1: Build frequency table
        // freq[x] = how many times x appears
        for (int i = 0; i < heights.length; i++) {
            freq[heights[i]]++;
        }

        int mismatch = 0;

        // Pointer to traverse original heights array
        int index = 0;

        // Step 2: Generate expected sorted order using frequencies
        for (int expected = 1; expected <= 100; expected++) {

            // Process current expected value until its frequency becomes 0
            while (freq[expected] > 0) {

                // Compare original value with expected sorted value
                if (heights[index] != expected) {
                    mismatch++;
                }

                // Move to next position in original array
                index++;

                // One occurrence of expected value is used
                freq[expected]--;
            }
        }
        return mismatch;
    }
}
