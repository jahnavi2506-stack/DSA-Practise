Pattern Recognition: Binary Tree → DFS / Recursion → Root-to-Leaf Path Sum

Whenever you see "root-to-leaf" + "path" + "sum", think:DFS + carry the remaining sum

Brute Force: Traverse every root-to-leaf path using DFS and keep the current path sum.
When you reach a leaf, check whether currentSum == targetSum.
If any leaf matches, return true; otherwise return false.
Time: O(n), Space: O(h) recursion stack, where h = tree height.

Even though we call this "brute force", we still visit each node only once. The difference is mainly that we explicitly carry the accumulated sum rather than using the cleaner remaining-target approach.

Optimal Approach: At each node, subtract its value from targetSum.
When we reach a leaf, check whether the remaining target equals that node's value.
Recursively check left OR right; if either gives true, return true.
Time: O(n) — every node is visited at most once, Space: O(h) — recursion stack.

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // If tree is empty, there is no root-to-leaf path
        if (root == null) {
            return false;
        }

        // Check if current node is a leaf
        if (root.left == null && root.right == null) {

            // If this leaf completes the required sum
            return targetSum == root.val;
        }

        // Subtract current node's value from target
        int remainingSum = targetSum - root.val;

        // Check left OR right subtree
        return hasPathSum(root.left, remainingSum)
            || hasPathSum(root.right, remainingSum);
    }
}
