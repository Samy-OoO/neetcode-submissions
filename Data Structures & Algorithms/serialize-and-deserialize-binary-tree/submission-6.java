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
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                res.append(String.valueOf(node.val) + ",");
                q.offer(node.left);
                q.offer(node.right);
            } else res.append("n" + ",");
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        if (vals[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);
        int i=1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!vals[i].equals("n")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(node.left);
            }
            i++;

            if (!vals[i].equals("n")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
