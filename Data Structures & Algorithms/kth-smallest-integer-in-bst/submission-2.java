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
        traverse(root, k);
        int small = stack.pop(); 
        return small;
    }

    public void traverse(TreeNode root, int k){   
        if(root != null){
            traverse(root.left, k);
            if (stack.size() < k) stack.push(root.val);
            else return;
            traverse(root.right, k);
        }
    }
}
