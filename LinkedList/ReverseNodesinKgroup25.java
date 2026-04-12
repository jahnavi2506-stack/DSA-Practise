Linked List + Group Reversal + Pointer Manipulation

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode prevGroupEnd = dummy;

      while(true) {
        ListNode kth = prevGroupEnd;

        //Finding kth node from prevGroupEnd
        for(int i = 0; i < k; i++) {
            kth = kth.next;
            if(kth == null) {
                return dummy.next;
            }
        }

        //store nextGroupStart
        ListNode nextGroupStart = kth.next;

        //Reverse current group
        ListNode prev = nextGroupStart;
        ListNode curr = prevGroupEnd.next;

        while(curr != nextGroupStart) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //connect prevGroup with next reversed group
        ListNode temp = prevGroupEnd.next;
        prevGroupEnd.next = kth;
        prevGroupEnd = temp;
      }   
    }
}//o(n) time complexity and o(1) space complexity