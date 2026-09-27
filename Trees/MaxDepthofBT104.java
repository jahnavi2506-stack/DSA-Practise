Pattern Recognition: Tree + Recursion / Divide and Conquer

Brute Force: Find depth of every root-to-leaf path
Traverse all possible root-to-leaf paths and calculate each path's length.
Store/compare the lengths to find the maximum.
This still visits every node, so it is effectively the same asymptotic complexity. Time: O(n), Space: O(h)

Optimal: Recursive DFS
If root == null, return 0. Recursively calculate leftDepth and rightDepth.
Return 1 + max(leftDepth, rightDepth). Time: O(n), Space: O(h)

class Solution {
    public int maxDepth(TreeNode root) {

        // Base case:
        // If there is no node, depth is 0
        if (root == null) {
            return 0;
        }

        // Find the maximum depth of the left subtree
        int leftDepth = maxDepth(root.left);

        // Find the maximum depth of the right subtree
        int rightDepth = maxDepth(root.right);

        // Add 1 for the current node
        // and take the deeper of the two subtrees
        return 1 + Math.max(leftDepth, rightDepth);
    }
}