Pattern Recognition: Heap/Priority Queue.

We must store ListNode references in the heap, not just values. After removing the smallest node, we need access to its next node so that
we can insert the next candidate from the same linked list. If we stored only values, we would lose the connection to the rest of that list.

Since each list is already sorted, only the current head of each list can be the next smallest element. Therefore, at any time we only need to 
compare at most K candidates. I use a min heap containing the current head node from each non-empty list. Repeatedly, I remove the smallest
node,append it to the answer, and insert its next node into the heap. Since the heap size never exceeds K and each of the N nodes is inserted 
and removed once, the complexity is O(N log K)

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap
        // Stores ListNode objects
        // Node with smaller value gets higher priority
        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add head of every non-empty list into heap
        // Initially only heads are candidates
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        // Dummy node helps avoid handling first node separately
        ListNode dummy = new ListNode(0);

        // Tail always points to last node of merged list
        ListNode tail = dummy;

        // Process until all nodes are consumed
        while (!minHeap.isEmpty()) {

            // Get smallest available node
            ListNode smallest = minHeap.poll();

            // Attach smallest node to result list
            tail.next = smallest;//connect next node 

            // Move tail forward
            tail = tail.next;//move the node to tail

            // If removed node has a next node,
            // it becomes the next candidate from that list
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        // Return merged list
        // Skip dummy node
        return dummy.next;
    }
}
dummy = fixed starting anchor of the result list.
tail = moving pointer that always stays at the last node of the result list