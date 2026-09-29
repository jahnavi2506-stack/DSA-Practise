Pattern Recognition: Recursive DFS is natural; iterative DFS uses a stack.

Brute Force: Use recursion: first traverse the left subtree, then the right subtree.
After both subtrees are processed, add the current node to result.
Time: O(n) | Space: O(h) recursion stack, worst case O(n).

Optimal Approach: Use an explicit stack to simulate recursion iteratively.
Process nodes in Root → Right → Left, then reverse the result to get Left → Right → Root.
Time: O(n) | Space: O(n) for stack + result/reversal.

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        // If tree is empty, return empty list
        if (root == null) {
            return result;
        }

        // Stack is used to simulate recursion
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            // Remove the top node
            TreeNode current = stack.pop();

            // First add Root
            // We will reverse the result at the end
            result.add(current.val);

            // Push LEFT first
            // Because stack is LIFO, RIGHT will be processed first
            if (current.left != null) {
                stack.push(current.left);
            }

            // Push RIGHT second
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        // Current order: Root -> Right -> Left
        // Reverse it to get: Left -> Right -> Root
        Collections.reverse(result);

        return result;
    }
}