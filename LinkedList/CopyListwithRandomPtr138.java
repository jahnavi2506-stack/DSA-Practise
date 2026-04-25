class Solution {
    public Node copyRandomList(Node head) {

        HashMap <Node, Node> map = new HashMap<>();

        if (head == null) return null;
    
        Node curr = head;
        while(curr != null) {
          Node copy = new Node(curr.val); //create a node
          map.put(curr, copy); //store key, value
          curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;

        }
        return map.get(head);
    }
}//o(N),o(N)

Since the map stores original node → copied node, when curr.random points to some original node, 
we can use the map to directly get its corresponding copied node and assign it to copy.random

Instead of storing mappings externally, I insert each copied node directly next to its original node in the list. 
This way, the mapping between original and copy is implicitly maintained.

“Once the copied nodes are interleaved with original nodes, I can assign random pointers efficiently. 
If an original node’s random points to some node X, then its copy’s random will point to X’s next node, which is the copied version of X.”

Pattern recognition:- Using node adjacency to simulate mapping
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;
        while(curr != null) {
          Node next = curr.next; // store next
          Node copy = new Node(curr.val); // create copy
          copy.next = next; 
          curr.next = copy;
          curr = next; // move to next original node
        }
   
         curr = head;
         while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next; 
            }
            curr = curr.next.next;
         }
            curr = head;
         Node copyHead = head.next;

         while(curr != null) {
            Node copy = curr.next;
            Node nextOriginal = curr.next.next;
            curr.next = nextOriginal;

            if(nextOriginal != null) {
                copy.next = nextOriginal.next;
            } else {
                copy.next = null;
            }
             curr = nextOriginal;
         }
         return copyHead;
    }
}
//o(N),o(1)