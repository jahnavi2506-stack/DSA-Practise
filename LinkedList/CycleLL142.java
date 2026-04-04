public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode slow = head; 
       ListNode fast = head;

       while(fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
          if(slow == fast) {
            ListNode movePtr = head;

            //create a new pointer and move both slow and movePtr one step at a time until they meet,
            //  the node where they meet is the start of the cycle

             while(movePtr != slow) { 
                movePtr = movePtr.next; 
                slow = slow.next;
             }
             return movePtr; // return either movePtr or slow, both are at the start of the cycle
          }
        }
        return null;
    }
}