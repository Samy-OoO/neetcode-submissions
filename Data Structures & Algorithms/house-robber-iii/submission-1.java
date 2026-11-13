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
    private Map<TreeNode, int[]> memo = new HashMap<>();

    public int rob(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean lastRob) {
        if (root == null) return 0;
        
        int[] slots = memo.computeIfAbsent(root, k -> new int[]{-1, -1});
        int state = lastRob ? 1 : 0;

        if (slots[state] != -1) return slots[state];

        int take = lastRob ? 0 : root.val + dfs(root.left, true) + dfs(root.right, true);
        int skip = dfs(root.left, false) + dfs(root.right, false);
        
        slots[state] = Math.max(take, skip);
        return slots[state];
    }
}