class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        ListNode curr = second;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null) {
          next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
        }

         ListNode first = head;
         second = prev;

        while(second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}//o(n) time, o(1) space - we traverse the list at most three times and use only a few pointers