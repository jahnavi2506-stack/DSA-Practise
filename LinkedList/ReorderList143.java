Pattern Recognition: Find Middle → Reverse Second Half → Merge Alternately

Brute Force: Store all nodes (or values) in an array/list for random access.
Use two pointers (left and right) to rebuild the required order by alternating from the front and back.
Easy to implement but requires extra memory, violating the O(1) space requirement. Time: O(n), Space: O(n)

Optimal: Use slow and fast pointers to find the middle of the linked list and split it into two halves.
Reverse the second half in-place using pointer manipulation.
Merge the first half and reversed second half alternately to produce the reordered list. Time: O(n) ,Space: O(1)

class Solution {
    public void reorderList(ListNode head) {

        // If the list has 0 or 1 node, no reordering is needed.
        if (head == null || head.next == null) {
            return;
        }

        // STEP 1: Find the middle of the linked list

        ListNode slow = head;
        ListNode fast = head;

        // Slow moves 1 step, Fast moves 2 steps.
        // When fast reaches the end, slow will be at the middle.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: Split the list into two halves

        // Second half starts after the middle node.
        ListNode second = slow.next;

        // Break the list into two separate lists.
        slow.next = null;

        // STEP 3: Reverse the second half

        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {

            // Store next node
            ListNode next = curr.next;

            // Reverse the link
            curr.next = prev;

            // Move pointers forward
            prev = curr;
            curr = next;
        }

        // 'prev' is now the head of the reversed second half.
        second = prev;

        // STEP 4: Merge the two halves alternately

        ListNode first = head;

        while (second != null) {

            // Save next nodes before changing links
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Connect one node from first half
            first.next = second;

            // Connect one node from second half
            second.next = temp1;

            // Move to the next pair
            first = temp1;
            second = temp2;
        }
    }
}