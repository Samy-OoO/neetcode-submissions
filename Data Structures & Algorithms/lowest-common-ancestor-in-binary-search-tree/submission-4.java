/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val = root.val;
        if ((p.val >= val && q.val <= val) || (p.val <= val && q.val >= val)) return root;
        else if (p.val > val & q.val > val) return lowestCommonAncestor(root.right, p, q);
        else return lowestCommonAncestor(root.left, p, q);
    }
}
