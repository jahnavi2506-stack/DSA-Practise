Pattern Recognition: Dutch National Flag Algorithm (3-Way Partitioning)

Brute Force:  Use any sorting algorithm (Arrays.sort()).
Sort entire array normally.
Extra work happens even though only 3 values exist.
Time: O(n log n), Space: O(1) 

Optimal Approach (Dutch National Flag)
Maintain 3 regions:
0 → low-1 = all 0s
low → mid-1 = all 1s
high+1 → end = all 2s
Traverse once using mid and swap accordingly.
Time: O(n) (single traversal), Space: O(1)

class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            // CASE 1 : current element is 0
            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }

            // CASE 2 : current element is 1
            else if (nums[mid] == 1) {
                mid++;
            }

            // CASE 3 : current element is 2
            else {

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;

                // IMPORTANT:
                // mid is NOT incremented here
            }
        }
    }
}

The Dutch National Flag (DNF) algorithm is a one-pass, in-place partitioning algorithm used when an array contains
three categories of elements and we want to arrange those categories in a particular order.

mid - current element to inspect
low - where the next 0 should go
high - where the next 2 should go