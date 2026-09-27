Pattern Recognition: BST Search - use the BST ordering property: left < root < right.
Compare val with root.val and eliminate the entire wrong subtree at every step.

Brute Force: Traverse every node like a normal Binary Tree until the value is found.
Time: O(n) | Space: O(h) with DFS recursion.

Optimal Approach: Use BST property: smaller → left, larger → right, equal → return current node.
Time: O(h) → O(log n) balanced, O(n) skewed | Space: O(h).

class Solution {

    public TreeNode searchBST(TreeNode root, int val) {

        // If we reach an empty position,
        // the value does not exist in the BST.
        if (root == null) {
            return null;
        }

        // If current node contains the required value,
        // return this node.
        if (root.val == val) {
            return root;
        }

        // If target value is smaller,
        // according to BST property it can only be on the left.
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // If target value is greater,
        // it can only be on the right.
        return searchBST(root.right, val);
    }
}