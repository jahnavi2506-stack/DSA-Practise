Pattern Recognition: copy + skip

Brute Force: If the head were available, traverse until the node before the target.
Change prev.next = target.next to remove the target node.
This approach is not possible in this problem because the head is not given. Time: O(N), Space: O(1)

Optimal: Copy the value of the next node into the current node.
Make node.next = node.next.next to bypass the next node.
The current node now behaves as if it were deleted. Time: O(1),Space: O(1)

class Solution {
    public void deleteNode(ListNode node) {

        // Step 1: Copy the value of the next node
        // Example:
        // Before: 4 -> 5 -> 1 -> 9
        //               ^
        //             node
        //
        // After copying:
        // 4 -> 1 -> 1 -> 9
        node.val = node.next.val;

        // Step 2: Skip the next node
        // node.next now points to node.next.next
        //
        // Before:
        // 4 -> 1 -> 1 -> 9
        //
        // After:
        // 4 -> 1 ------> 9
        //
        // Final List:
        // 4 -> 1 -> 9
        node.next = node.next.next;
    }
}