Pointer Manipulation + Iterative Rewiring

Brute Force: Store all node values in an array/list.
Traverse the linked list again and rewrite node values in reverse order.
The links remain unchanged; only the values are modified.
Time Complexity: O(N), Space Complexity: O(N)

Optimal Approach: Traverse the linked list only once.
Reverse every next pointer while moving through the list.
Maintain three pointers (prev, curr, next) so no nodes are lost.
Time Complexity: O(N), Space Complexity: O(1)

class Solution {
    public ListNode reverseList(ListNode head) {

        // Previous node (initially null because the new tail points to null)
        ListNode prev = null;

        // Current node starts from the head
        ListNode curr = head;

        // Traverse until all nodes are processed
        while (curr != null) {

            // Step 1: Store the next node before changing the link
            ListNode next = curr.next;

            // Step 2: Reverse the current node's pointer
            curr.next = prev;

            // Step 3: Move prev one step forward
            prev = curr;

            // Step 4: Move curr one step forward
            curr = next;
        }

        // prev becomes the new head after reversal
        return prev;
    }
}
