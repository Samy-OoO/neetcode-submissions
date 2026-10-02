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
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        int res = root.val;
        dfs(root, q);

        for (int i=0; i < k; i++) {
            res = q.poll();
        }
        return res;
    }

    private void dfs(TreeNode root, Queue<Integer> q) {
        if (root != null) {
            dfs(root.left, q);
            q.offer(root.val);
            dfs(root.right, q);
        }
    }
}
