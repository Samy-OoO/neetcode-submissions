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
    public boolean search(TreeNode root, int key){
        boolean res;

        if (root == null) return false;

        if (key == root.val) return true;
        else if (key < root.val) res = search(root.left, key);
        else res = search(root.right, key);
        return res;
    }


    public TreeNode deleteNode(TreeNode root, int key){
        if (!search(root, key)) return root;

        root = deleteHelper(root, key);
        return root;
    }
    public TreeNode deleteHelper(TreeNode root, int key){
        if (root == null) return root;
        else if (key < root.val) root.left = deleteHelper(root.left, key);
        else if (key > root.val) root.right = deleteHelper(root.right, key);
        else {
            if (root.right == null && root.left == null){
                root = null;
            } else if (root.left != null){
                root.val = predecessor(root);
                root.left = deleteHelper(root.left, root.val);
            } else {
                root.val = successor(root);
                root.right = deleteHelper(root.right, root.val);
            }
        }
        return root;
    }

    public int predecessor(TreeNode root){
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root.val;
    }
    public int successor(TreeNode root){
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }
}