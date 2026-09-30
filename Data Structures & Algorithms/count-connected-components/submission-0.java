class Solution {
    public int countComponents(int n, int[][] edges) {

        // Create the Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i < n; i++) {
            adj.add(new LinkedList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        // DFS thru until all components are found.
        int i = 0;
        int count = 0;
        while (i < n && visit.size() != n) {
            if (!visit.contains(i)) {
                dfs(i, -1, visit, adj);
                count++;
            }
            i++;     
        }

        return count;     

    }

    private void dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj) {
        // Handles cycles
        if (visit.contains(node)) return;

        visit.add(node);        
        for (int nei : adj.get(node)) {
            if (nei == parent) continue;
            dfs(nei, node, visit, adj);
        }
    }
}
