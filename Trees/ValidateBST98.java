Pattern Recognition: Tree + Range/Boundary Validation

Brute Force: Check left maximum and right minimum
For every node, find the maximum value in its left subtree.
Find the minimum value in its right subtree.
Check leftMax < node.val < rightMin, then recursively check both subtrees. Time: O(n²) worst case, Space: O(h)

Optimal: DFS with min/max boundaries
Start root with (-∞, +∞).
Check min < node.val < max.
Update boundaries while moving left/right. Time: O(n), Space: O(h)

class Solution {
    public boolean isValidBST(TreeNode root) {

        // Root can have any value initially,
        // so its valid range is (-∞, +∞)
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, long min, long max) {

        // Empty subtree is always a valid BST
        if (node == null) return true;

        // Current node must be strictly between min and max
        // Equal values are NOT allowed in a BST
        if (node.val <= min || node.val >= max) return false;

        // Left subtree:
        // All values must be smaller than node.val
        // Range becomes (min, node.val)
        //
        // Right subtree:
        // All values must be greater than node.val
        // Range becomes (node.val, max)
        return isValid(node.left, min, node.val) &&
               isValid(node.right, node.val, max);
    }
}