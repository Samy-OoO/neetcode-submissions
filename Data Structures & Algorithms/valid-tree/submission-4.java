class Solution {
    public boolean validTree(int n, int[][] edges) {

        // Create the Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i < n; i++) {
            adj.add(new LinkedList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        
        // Checks if all nodes are connected (DFS thru any 1 node must visit all)
        Set<Integer> visit = new HashSet<>();
        // Does a cycle exist?
        if (dfs(0, -1, visit, adj)) return false;
        
        return visit.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj) {
        if (visit.contains(node)) return true;

        visit.add(node);        
        for (int nei : adj.get(node)) {
            if (nei == parent) continue;
            if (dfs(nei, node, visit, adj)) return true;
        }

        return false;
    }
}
