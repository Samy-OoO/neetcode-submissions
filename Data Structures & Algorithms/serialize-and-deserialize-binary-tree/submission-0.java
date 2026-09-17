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
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            for (int i=q.size(); i>0; i--) {
                TreeNode node = q.poll();

                if (node != null) {
                    str.append(node.val).append("#");
                    q.offer(node.left);
                    q.offer(node.right);
                } 
                else str.append("n").append("#");
            }
        }

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        int l=0, r=1, num;
        Queue<Integer> q = new LinkedList<>();

        while (l < data.length()) {
            while (data.charAt(r) != '#') r++;
            if (data.charAt(l) == 'n') {
                q.offer(null);
            } else {
                num = Integer.parseInt(data.substring(l, r));
                q.offer(num);
            }
            l = r + 1;
            r = l;
        }
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<Integer> values) {
        if (values.isEmpty()) return null;

        Integer first = values.poll();
        if (first == null) return null;

        TreeNode root = new TreeNode(first);
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!values.isEmpty()) {
            TreeNode current = nodes.poll();

            // left
            Integer left = values.poll();
            if (left != null) {
                current.left = new TreeNode(left);
                nodes.offer(current.left);
            }

            // right
            if (!values.isEmpty()) {
                Integer right = values.poll();
                if (right != null) {
                    current.right = new TreeNode(right);
                    nodes.offer(current.right);
                }
            }
        }

        return root;
    }
}
