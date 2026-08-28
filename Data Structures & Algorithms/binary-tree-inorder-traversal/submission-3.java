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
    private List<Integer> list; 
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    public void traverse(TreeNode root){
        if (root != null){
            traverse(root.left);
            list.add(root.val);
            traverse(root.right);
        }
    }

}