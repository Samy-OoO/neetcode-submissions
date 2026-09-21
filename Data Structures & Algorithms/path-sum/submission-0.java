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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traverse(root, 0, targetSum);
    }

    private boolean traverse(TreeNode root, int curSum, int targetSum) {
        if (root == null) return false;

        curSum += root.val;
        if (curSum == targetSum && root.left == null && root.right == null) return true;

        boolean right = traverse(root.right, curSum, targetSum);
        boolean left = traverse(root.left, curSum, targetSum);

        return right || left;

    }
}