Pattern Recognition: Tree + Recursion + Compare Two Nodes

Brute Force

Pattern: Traversal + Store Tree Information

Traverse both trees and store their values and structure in arrays/lists.
Compare the two stored representations.
If both representations are identical, the trees are the same.

Time: O(n)
Space: O(n)

Brute force uses extra storage; recursion compares them directly.

3. Optimal Approach: Simultaneous DFS

At every pair of nodes:
Both null        → true
One null         → false
Values different → false
Otherwise        → check left AND right

Compare p and q at the same position.
Both must have the same structure and same value.
Recursively compare p.left ↔ q.left and p.right ↔ q.right. Time: O(n),Space: O(h)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null → same structure at this position
        if (p == null && q == null) {
            return true;
        }

        // Only one is null → structures are different
        if (p == null || q == null) {
            return false;
        }

        // Values are different → trees cannot be same
        if (p.val != q.val) {
            return false;
        }

        // Compare corresponding left and right subtrees
        // Both must be identical
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}


