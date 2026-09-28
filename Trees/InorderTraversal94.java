Pattern Recognition: DFS + recursion 

Brute Force: Traverse the tree and collect all node values.
Then arrange/process the nodes according to Left → Root → Right.
This adds unnecessary work because traversal itself can produce the answer in order.
Time: O(n log n) if sorting is used, Space: O(n)

Optimal: Use DFS and visit left subtree first.
Add the current node's value.
Visit the right subtree; iteratively, use a stack to simulate recursion.
Time: O(n), Space: O(h) — recursion stack / explicit stack.

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        // Create a list to store the inorder traversal
        List<Integer> result = new ArrayList<>();

        // Call the recursive helper function
        // It will add nodes in: LEFT → ROOT → RIGHT order
        inorder(root, result);

        // Return the final inorder traversal
        return result;
    }

    // Helper function for recursive inorder traversal
    private void inorder(TreeNode root, List<Integer> result) {

        // Base case:
        // If there is no node, stop the recursion
        if (root == null) {
            return;
        }

        // 1. Visit LEFT subtree
        inorder(root.left, result);

        // 2. Process the current ROOT node
        result.add(root.val);

        // 3. Visit RIGHT subtree
        inorder(root.right, result);
    }
}