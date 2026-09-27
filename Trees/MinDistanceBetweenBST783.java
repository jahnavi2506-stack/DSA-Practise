Pattern Recognition: BST + minimum/maximum difference → think Inorder Traversal.
Inorder of a BST gives values in ascending order.
So the minimum difference can only occur between adjacent values in inorder.

Brute Force: Store all node values in an array using any traversal.
Compare every pair of values and find the minimum absolute difference.
This works, but checks unnecessary pairs. Time: O(n²),Space: O(n)

Optimal Approach: Perform inorder traversal so nodes are visited in sorted order.
Compare the current node with the previously visited node.
Keep updating minDiff = min(minDiff, current.val - prev.val). Time: O(n),Space: O(h) for recursion

class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;  // Previous node in inorder traversal

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {

        // Base case: nothing to process
        if (root == null) {
            return;
        }

        // 1. Visit left subtree
        inorder(root.left);

        // 2. Process current node
        // Inorder gives values in sorted order,
        // so current.val >= prev.val
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }

        // Current node becomes previous for the next node
        prev = root;

        // 3. Visit right subtree
        inorder(root.right);
    }
}

