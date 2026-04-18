class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode fast = dummy;
       ListNode slow = dummy;

       for(int i = 0; i <= n; i++) {
        fast = fast.next;
       }
       
       while(fast != null) {
          fast = fast.next;
          slow = slow.next;
       }
        slow.next = slow.next.next;
        return dummy.next; 
    }
}
//o(m) time, o(1) space - we traverse the list at most twice and use only a few pointers

BRUTE FORCE APPROACH:
Count length L
Find node at position (L - n)
Delete it  //o(2N) time, o(1) space - we traverse the list twice and use only a few pointers