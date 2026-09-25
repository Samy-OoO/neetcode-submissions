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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = root.val;
        dfs(root, res);
        return res[0];
    }
    
    private int dfs(TreeNode root, int[] res) {
        if (root == null) return 0;

        // If negative then disregard the child
        int left = Math.max(dfs(root.left, res), 0);
        int right = Math.max(dfs(root.right, res), 0);

        int sum = right + root.val + left;
        res[0] = Math.max(res[0], sum);
        return root.val + Math.max(left, right);
    }

}
