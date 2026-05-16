Pattern Recognition:- Merge Sort based counting

Brute Force Approach
Use two loops (i, j) such that i < j.
Check condition: nums[i]>2×nums[j] and count valid pairs. Every pair is checked individually.
Time  Complexity: O(n^2), Space:O(1)

Optimal Approach (Merge Sort Based)
Divide array into left and right halves using Merge Sort.
Since both halves become sorted, count reverse pairs efficiently using two pointers before merging.
If: left[i]>2*right[j] then all remaining elements after i in left half also satisfy the condition because left half is sorted.
Time Complexity: O(nlogn), Space:O(n)

