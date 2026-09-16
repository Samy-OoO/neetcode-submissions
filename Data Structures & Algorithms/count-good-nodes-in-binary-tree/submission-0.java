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
    public int goodNodes(TreeNode root) {
        return checkNode(root, root.val, Long.MAX_VALUE);
    }

    private int checkNode(TreeNode node, long leftLim, long rightLim) {
        if (node == null) return 0;
        leftLim = Math.max(node.val, leftLim);
        int good = checkNode(node.left, leftLim, rightLim) + checkNode(node.right, leftLim, rightLim);
        if (node.val >= leftLim && node.val < rightLim) good++;
        return good;
    }
}
