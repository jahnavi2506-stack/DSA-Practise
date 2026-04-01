class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        // Step 1: Create a dummy node to handle edge cases (like deleting head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize two pointers
        ListNode prev = dummy; // points to last valid (kept) node
        ListNode curr = head;  // used to traverse the list

        // Step 3: Traverse the list
        while (curr != null) {
            
            // Step 4: If current node needs to be deleted
            if (curr.val == val) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move prev only when node is kept
                // prev should always point to last valid node
                prev = curr;
            }

            // Step 5: Always move curr forward
            curr = curr.next;
        }

        // Step 6: Return the new head (may be different from original head)
        return dummy.next;
    }
}// Time complexity: O(n) - we traverse the list once
// Space complexity: O(1) - we use only a few pointers, no extra space