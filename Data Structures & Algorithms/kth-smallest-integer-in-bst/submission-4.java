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
    
    Stack<Integer> stack = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        fill(root);
        int res = 0;
        for (int i=0; i<k; i++) {
            res = stack.pop();
        }
        return res;
    }

    private void fill(TreeNode root) {
        if (root != null) {
            fill(root.right);
            stack.push(root.val);
            fill(root.left);
        }
    }
}
