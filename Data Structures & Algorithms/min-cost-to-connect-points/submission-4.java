class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Create Graph (Edge List)
        List<int[]> edges = new ArrayList<>();

        int idx=0;
        for (int i=0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];

            for (int j=i+1; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x2-x1) + Math.abs(y2-y1);
                edges.add(new int[]{i, j, dist});
            }
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i=0; i < n; i++) parent[i] = i;

        int cost = 0, edgesUsed = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            if (union(u, v, parent, rank)) {
                cost += w;
                edgesUsed++;

                if (edgesUsed == n-1) break;
            }
        }

        return cost;
    }

    private int find(int x, int[] aprent) {
        if (aprent[x] != x) {
            aprent[x] = find(aprent[x], aprent);
        }
        return aprent[x];
    }

    private boolean union(int a, int b, int[] aprent, int[] rank) {
        int rootA = find(a, aprent);
        int rootB = find(b, aprent);

        if (rootA == rootB) return false;

        if (rank[rootA] < rank[rootB]) aprent[rootA] = rootB;
        else if (rank[rootA] > rank[rootB]) aprent[rootB] = rootA;
        else {
            aprent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }
}
