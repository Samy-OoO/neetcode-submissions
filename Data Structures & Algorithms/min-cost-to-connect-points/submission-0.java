class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // Create Graph
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i=0; i < n; i++) adj.put(i, new ArrayList<>());

        for (int i=0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];

            for (int j=i+1; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x2-x1) + Math.abs(y2-y1);
                
                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }


        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{0, 0});
        int cost = 0, edgesUsed = 0;

        while (!minHeap.isEmpty() && edgesUsed < n) {
            int[] edge = minHeap.poll();
            int node = edge[0], dist = edge[1];

            if (visited[node]) continue;

            visited[node] = true;
            cost += dist;
            edgesUsed++;

            for (int[] nei : adj.get(node)) {
                if (!visited[nei[0]]) minHeap.offer(new int[]{nei[0], nei[1]});
            }
        }

        return cost;
    }
}
