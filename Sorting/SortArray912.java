Pattern Recognition:- 

Brute Force Approach — Bubble Sort
Repeatedly compare adjacent elements and swap if they are in wrong order.
After every pass, the largest element moves to its correct position at the end.
Continue until array becomes sorted. Time: O(n²), Space: O(1)

Optimal Approach — Merge Sort
Divide array recursively into two halves until single elements remain.
Merge the sorted halves by comparing elements and building a sorted array.
Repeating divide + merge gives efficient sorting. Time: O(n log n), Space: O(n)

class Solution {

    public int[] sortArray(int[] nums) {

        // Start merge sort on full array
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    // Recursive function to divide array
    private void mergeSort(int[] nums, int left, int right) {

        // Base condition:
        // If only one element, already sorted
        if (left >= right) {
            return;
        }

        // Find middle index
        int mid = left + (right - left) / 2;

        // Sort left half
        mergeSort(nums, left, mid);

        // Sort right half
        mergeSort(nums, mid + 1, right);

        // Merge both sorted halves
        merge(nums, left, mid, right);
    }

    // Function to merge two sorted halves
    private void merge(int[] nums, int left, int mid, int right) {

        // Temporary array to store merged result
        int[] temp = new int[right - left + 1];

        // Pointer for left half
        int i = left;

        // Pointer for right half
        int j = mid + 1;

        // Pointer for temp array
        int k = 0;

        // Compare elements from both halves
        while (i <= mid && j <= right) {

            // Smaller element goes into temp
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        // Remaining elements from left half
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        // Remaining elements from right half
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // Copy temp back into original array
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}