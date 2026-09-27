Pattern Recognition: BST + Range → check whether each node's value lies in [low, high].
Use BST property to prune subtrees that cannot contain valid values.
node < low → go right, node > high → go left, otherwise explore both sides.

Brute Force: Traverse every node like a normal Binary Tree using DFS.
If low <= root.val <= high, add root.val to the sum.
Time: O(n) | Space: O(h)

Optimal Approach: Use BST ordering to avoid traversing subtrees that cannot contain values in the range.
If root.val < low, only the right subtree can contain valid values; if root.val > high, only left.
Time: O(h + k) average/pruned traversal | Space: O(h), where k is the number of relevant nodes.

class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {

        // If the tree/subtree is empty, contribute 0.
        if (root == null) {
            return 0;
        }

        // Current value is smaller than low.
        // Everything on the left is even smaller,
        // so only search the right subtree.
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // Current value is greater than high.
        // Everything on the right is even greater,
        // so only search the left subtree.
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Current value is inside [low, high].
        // Include it and search both subtrees.
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}