Pattern Recognition: Binary Search on Answer Space(Monotonic Function)

MONOTONIC PROPERTY: values change only once,one-directional transition exists

Brute Force Approach: Start checking versions one by one from `1` to `n` using `isBadVersion(version)`.
The first version that returns `true` is the first bad version.
Time Complexity: O(n), Space Complexity: O(1)

Optimal: Since versions follow a monotonic pattern (`good → bad`), apply Binary Search to find the first bad version.
If `mid` is bad, search left side including `mid`; otherwise search right side excluding `mid`.
Time Complexity: O(log n), Space Complexity: O(1)


public class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        // Search space starts from version 1 to version n
        int left = 1;
        int right = n;

        /*
            We use Binary Search because:

            Good versions -> False
            Bad versions  -> True

            Pattern looks like:
            F F F F T T T T

            We need to find the FIRST TRUE (first bad version).
        */

        while (left < right) {

            /*
                Safer way to calculate mid.

                Prevents integer overflow that may happen in:
                (left + right) / 2
            */
            int mid = left + (right - left) / 2;

            /*
                If mid is BAD:

                mid itself can be the first bad version,
                so we KEEP mid in the search space.

                Search on LEFT side including mid.
            */
            if (isBadVersion(mid)) {

                right = mid;
            }

            /*
                If mid is GOOD:

                first bad version must be after mid.

                So discard mid and move to RIGHT side.
            */
            else {

                left = mid + 1;
            }
        }

        /*
            When loop ends:
            left == right

            Both point to the first bad version.
        */
        return left;
    }
}

