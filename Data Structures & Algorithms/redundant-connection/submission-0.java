class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        int[] rank = new int[n+1];
        
        for (int i=1; i <= n; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], par, rank)) return new int[]{edge[0], edge[1]};
        }
        return new int[0];
    }

    private int find(int n, int[] par) {
        if (n != par[n]) par[n] = find(par[n], par);
        return par[n];
    }

    private boolean union(int n1, int n2, int[] par, int[] rank) {
        int p1 = find(n1, par), p2 = find(n2, par);

        if (p1 == p2) return false;

        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
