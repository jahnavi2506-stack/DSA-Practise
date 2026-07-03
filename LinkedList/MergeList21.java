Brute Force Approach: Traverse both linked lists and store all values in an array.
Sort the array and create a new linked list from the sorted values.
Return the head of the newly created linked list. Time Complexity: O((n + m) log(n + m)), Space Complexity: O(n + m)

Optimal Approach (Two Pointers): Compare the current nodes of both linked lists.
Attach the smaller node to the merged list and move that pointer forward.
When one list ends, attach the remaining nodes of the other list. Time Complexity: O(n + m), Space Complexity: O(1) (excluding the dummy node)

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy; // To build a new list safely

        while(list1 != null && list2 != null) {
           if(list1.val < list2.val) { 
             current.next = list1;
             list1 = list1.next;
             current = current.next;
            } else {
             current.next = list2; // attach node
             list2 = list2.next; //move forward
             current = current.next; //move current pointer forward
           }
        }
         current.next = (list1 != null) ? list1 : list2;
         return dummy.next;
    }
}//o(n + m) time, o(1) space - we traverse both lists once and use only a few pointers
