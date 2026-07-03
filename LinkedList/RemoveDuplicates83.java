Pattern Recognition: Two-pointers

Brute Force Approach (Using ArrayList): Traverse the linked list and store only unique values in an ArrayList.
Traverse the linked list again and overwrite node values using the unique elements.
Cut off the remaining duplicate nodes by setting the last unique node's next to null.
Time Complexity: O(n), Space Complexity: O(n) (extra list to store unique values)

Optimal Approach (Two Pointers): Traverse the sorted linked list using a single pointer.
If the current node and next node have the same value, skip the duplicate node.
Otherwise, move to the next node until the end of the list. Time Complexity: O(n), Space Complexity: O(1)

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