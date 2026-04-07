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
        ListNode curr = prev.next;
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