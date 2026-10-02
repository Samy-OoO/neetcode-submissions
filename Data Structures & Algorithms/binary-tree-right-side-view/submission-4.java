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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int right = Integer.MAX_VALUE;
            for (int i = q.size()-1; i >= 0; i--) {
                TreeNode node = q.poll();

                if (node != null) {
                    right = node.val;
                    q.offer(node.left);
                    q.offer(node.right);
                }         
            }
            if (right != Integer.MAX_VALUE) res.add(right);
        }

        return res;
    }
}
