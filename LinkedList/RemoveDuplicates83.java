Sorted Linked List + Remove Duplicates

no extra space -- “Because the list is sorted, duplicates are adjacent, so I can remove them in one pass.”
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        
        while (curr != null && curr.next != null) { //null pointer exception, invalid access
          if(curr.val == curr.next.val){ //checks duplicate
            curr.next = curr.next.next; //delete duplicate by skipping it
          } else {
            curr = curr.next;
          }
        }
        return head;
    }
}//o(n) time, o(1) space
IF duplicate → delete and STAY
IF not duplicate → MOVE