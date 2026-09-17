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
    int preIdx = 0, inIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i=0; i<preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                mid = i;
                break;
            }
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(preLeft, inLeft);

        int[] preRight = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] inRight = Arrays.copyOfRange(inorder, mid+1, inorder.length);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}
