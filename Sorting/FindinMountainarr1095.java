Pattern Recognition: Binary Search on Answer Space

Peak is important because: it partitions the array into two monotonic regions

Brute Force Approach: Traverse the mountain array from index `0 → n-1` using `get(i)` and compare each element with `target`.
If target is found, immediately return its index; otherwise return `-1` after complete traversal.
Time Complexity: `O(n)` , Space Complexity: `O(1)`

Optimal: First find the peak element using binary search by checking increasing/decreasing slope using `mid` and `mid+1`.
Then apply binary search on the left ascending half first, and if not found, apply binary search on the right descending half.
Time Complexity: `O(log n)` , Space Complexity: `O(1)`


class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        // Step 1: Find peak index
        int peak = findPeak(mountainArr, n);

        // Step 2: Search in left ascending part
        int leftSearch = binarySearchAscending(mountainArr, target, 0, peak);

        // If found in left side, return immediately
        // because we need minimum index
        if (leftSearch != -1) {
            return leftSearch;
        }

        // Step 3: Search in right descending part
        return binarySearchDescending(mountainArr, target, peak + 1, n - 1);
    }

    // Function to find peak element index
    private int findPeak(MountainArray mountainArr, int n) {

        int left = 0;
        int right = n - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            int midValue = mountainArr.get(mid);
            int nextValue = mountainArr.get(mid + 1);

            // Increasing slope
            // Peak lies on right side
            if (midValue < nextValue) {
                left = mid + 1;
            }

            // Decreasing slope
            // Mid can be peak or peak lies on left side
            else {
                right = mid;
            }
        }

        // left == right => peak index
        return left;
    }

    // Standard Binary Search on Ascending Sorted Array
    private int binarySearchAscending(MountainArray mountainArr,
                                      int target,
                                      int left,
                                      int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = mountainArr.get(mid);

            // Target found
            if (value == target) {
                return mid;
            }

            // Move right
            else if (value < target) {
                left = mid + 1;
            }

            // Move left
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    // Binary Search on Descending Sorted Array
    private int binarySearchDescending(MountainArray mountainArr,
                                       int target,
                                       int left,
                                       int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = mountainArr.get(mid);

            // Target found
            if (value == target) {
                return mid;
            }

            // In descending order:
            // smaller values are on RIGHT side
            else if (value > target) {
                left = mid + 1;
            }

            // larger values are on LEFT side
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}