Pattern Recognition:- Circular Array twist + Monotonic Stack pattern

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

       Stack <Integer> st = new Stack<>(); 

       for(int i = 0; i < 2*n; i++) {
        int curr = nums[i % n];

        while(!st.isEmpty() && curr > nums[st.peek()]) {
            int ele = st.pop();
            result[ele] = curr;
            
        }
        if(i < n) {
            st.push(i);
        }

       }
       return result;
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        // Result array initialized with -1
        // Default: if no next greater element exists
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Monotonic stack (stores indices)
        // Stack will store indices of elements waiting for next greater element
        Deque<Integer> st = new ArrayDeque<>();

        // Traverse 2*n - 1 times to simulate circular array
        for (int i = 0; i < 2*n - 1; i++) {

            // Current element (using modulo for circular behavior)
            int curr = nums[i % n];

            // Resolve elements from stack if current element is greater
            while (!st.isEmpty() && curr > nums[st.peek()]) {

                // Index of element whose next greater element is found
                int idx = st.pop();

                // Fill result for that index
                result[idx] = curr;
            }

            // Push index only in first pass
            // Second pass is only for resolving pending elements
            if (i < n) {
                st.push(i);
            }
        }

        return result;
    }
}