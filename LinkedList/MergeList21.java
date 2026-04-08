class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

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