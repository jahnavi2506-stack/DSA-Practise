class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;     // will become new head
        ListNode curr = head;     // start from first node

        while (curr != null) {
            ListNode next = curr.next; // 1. save next node
            curr.next = prev;          // 2. reverse link
            prev = curr;               // 3. move prev forward
            curr = next;               // 4. move curr forward
        }
        return prev; // new head
    }
}//o(n) time, o(1) space
