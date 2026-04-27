Pattern Recognition:- Monotonic Stack(elements kept in specific order)


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // Stack - to keep elements whose next greater is not found yet
        Stack<Integer> st = new Stack<>();

        // HashMap - to store (element → next greater element)
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Process nums2 and build next greater mapping
        for (int i = 0; i < nums2.length; i++) {
            int curr = nums2[i];

            // If current element is greater than stack top,
            // then it is the next greater element for stack top
            while (!st.isEmpty() && curr > st.peek()) {
                int ele = st.pop();           // element waiting for answer
                map.put(ele, curr);           // assign next greater
            }

            // Push current element - it is still waiting for its next greater
            st.push(curr);
        }

        // Step 2: Handle remaining elements in stack
        // These elements have no next greater element
        while (!st.isEmpty()) {
            int ele = st.pop();
            map.put(ele, -1);                 // assign default value
        }

        // Step 3: Build result for nums1 using map
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            // Direct lookup → O(1)
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
