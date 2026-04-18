Linked List Partial Reversal (Head-Insertion Technique)

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 1. Edge case
        if (head == null || left == right) return head;

        // 2. Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 3. Move prev to node before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 4. Start reversing using head-insertion
        ListNode curr = prev.next; //Start working from the FIRST node of the sublist
        ListNode next = null;

        for (int i = 0; i < (right - left); i++) {
            next = curr.next;          // 1. take next node
            curr.next = next.next;     // 2. remove next
            next.next = prev.next;     // 3. insert after prev
            prev.next = next;          // 4. connect prev to next
        }

        return dummy.next;
    }
}
//o(n) time complexity because we are traversing the list at most twice (once to reach the left position and once to reverse the sublist). 
// O(1) space complexity because we are using only a constant amount of extra space for pointers.
//curr does not move because We are inserting nodes before curr, So curr automatically shifts

Brute force approach:
copy the values of the nodes in the sublist to an array, reverse the array, and then copy the values back to the nodes.
 This approach has O(n) time complexity and O(n) space complexity due to the additional array used for storing values.