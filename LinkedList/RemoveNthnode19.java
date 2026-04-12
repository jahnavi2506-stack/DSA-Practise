class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode fast = head;
       ListNode slow = head;

       for(int i = 0; i < n; i++) {
        fast = fast.next;
       }
       
       if(fast == null) return head.next;

       while(fast.next != null) {
          fast = fast.next;
          slow = slow.next;
       }
        slow.next = slow.next.next;
        return head; 
    }
}//o(m) time, o(1) space - we traverse the list at most twice and use only a few pointers