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

        traverse(root);

        int small = 0;;
        for(int i=1; i<=k; i++){
            small = stack.pop();
        }   
        return small;
    }

    public int traverse(TreeNode root){
        if(root != null){
            traverse(root.right);
            stack.push(root.val);
            traverse(root.left);
        }
        return 0;
    }
}
