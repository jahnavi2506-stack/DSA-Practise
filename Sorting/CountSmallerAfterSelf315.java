Pattern Recognition: Merge Sort + Index Tracking + Counting

Merge sort changes element positions during sorting, but the final answer must correspond to original array indices. 
Therefore we must track original indices while merging and counting.

Brute Force: For every element, scan all elements to its right and count how many are smaller.
Store that count in the answer array for the current index. This uses nested loops and compares every possible pair.
Time Complexity: O(n^2), Space Complexity: O(1) auxiliary, output array excluded


Optimal Solution
Use Merge Sort with (value, originalIndex) pairs to preserve original positions while sorting.
During merge, whenever a right-half element crosses before a left-half element, increase crossed-smaller count.
When placing a left element, add crossed count to its answer because those crossed right elements are smaller and originally on its right side.
Time Complexity: O(n log n),Space Complexity: O(n)

class Solution {

    // Pair class to store:
    // value -> actual number
    // index -> original position in array
    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        // answer array
        int[] result = new int[n];

        // create pair array
        Pair[] arr = new Pair[n];

        // store value + original index
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // merge sort with counting
        mergeSort(arr, 0, n - 1, result);

        // convert int[] to List<Integer>
        List<Integer> ans = new ArrayList<>();

        for (int val : result) {
            ans.add(val);
        }

        return ans;
    }

    public void mergeSort(Pair[] arr, int low, int high, int[] result) {

        // base condition
        // single element is already sorted
        if (low >= high) {
            return;
        }

        // safe mid calculation
        int mid = low + (high - low) / 2;

        // sort left half
        mergeSort(arr, low, mid, result);

        // sort right half
        mergeSort(arr, mid + 1, high, result);

        // merge while counting
        merge(arr, low, mid, high, result);
    }

    public void merge(Pair[] arr, int low, int mid, int high, int[] result) {

        // temporary list for merged elements
        List<Pair> temp = new ArrayList<>();

        int i = low;
        int j = mid + 1;

        // stores how many right elements crossed before left element
        int crossedSmallerCount = 0;

        // merge both halves
        while (i <= mid && j <= high) {

            // right element is smaller
            if (arr[j].value < arr[i].value) {

                // this right element crossed before left element
                crossedSmallerCount++;

                // place right element
                temp.add(arr[j]);

                j++;
            }

            // left element is smaller or equal
            else {

                // all crossed right elements are smaller than current left
                result[arr[i].index] += crossedSmallerCount;

                // place left element
                temp.add(arr[i]);

                i++;
            }
        }

        // remaining left elements
        while (i <= mid) {

            // crossed right elements are still smaller
            result[arr[i].index] += crossedSmallerCount;

            temp.add(arr[i]);

            i++;
        }

        // remaining right elements
        while (j <= high) {

            temp.add(arr[j]);

            j++;
        }

        // copy back to original array
        for (int k = low; k <= high; k++) {
            arr[k] = temp.get(k - low);
        }
    }
}