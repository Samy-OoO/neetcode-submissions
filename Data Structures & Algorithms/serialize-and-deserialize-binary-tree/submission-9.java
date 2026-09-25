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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfsSerialize(root, res);
        return res.toString();     
    }
    private void dfsSerialize(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("n" + ",");
            return;
        }

        res.append(String.valueOf(root.val) + ",");
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsDeserialize(vals, i);
    }
    private TreeNode dfsDeserialize(String[] vals, int[] i) {
        if (vals[i[0]].equals("n")) {
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        root.left = dfsDeserialize(vals, i);
        root.right = dfsDeserialize(vals, i);

        return root;        
    }
}
