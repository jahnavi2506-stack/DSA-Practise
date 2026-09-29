Pattern Recognition: Recursive DFS is natural; iterative DFS uses a stack.

Brute Force: Use recursion: visit the current node, recursively traverse left, then right.
Store each visited node's value in the result list.
Time: O(n) | Space: O(h) recursion stack, worst case O(n).

Optimal Approach: Use an explicit stack instead of recursion.
Pop a node → add it to result → push right first, then left so left is processed first.
Time: O(n) | Space: O(h), worst case O(n).

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        // Call helper function to perform preorder traversal
        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {

        // If node is null, stop
        if (root == null) {
            return;
        }

        // Preorder: Root -> Left -> Right

        // 1. Visit root
        result.add(root.val);

        // 2. Traverse left subtree
        preorder(root.left, result);

        // 3. Traverse right subtree
        preorder(root.right, result);
    }
}