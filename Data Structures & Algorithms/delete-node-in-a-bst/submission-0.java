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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null && root.right == null){
                root = null;
            } else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int successor(TreeNode root){
        TreeNode cur = root.right;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur.val;
    }

    private int predecessor(TreeNode root){
        TreeNode cur = root.left;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur.val;
    }
}