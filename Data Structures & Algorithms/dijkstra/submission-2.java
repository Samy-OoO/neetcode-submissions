class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        // Creating an Adjacency List for a weighted, directed Graph.
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i=0; i < n; i++) {
            adj.put(i, new LinkedList<>());
        }

        for (List<Integer> edge : edges) {
            int s = edge.get(0), d = edge.get(1), w = edge.get(2);
            adj.get(s).add(new int[]{d, w});
        }


        Map<Integer, Integer> minPaths = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{src, 0});
        
        while (!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();
            int n1 = edge[0], w1 = edge[1];

            if (minPaths.containsKey(n1)) continue;
            minPaths.put(n1, w1);

            for (int[] nei : adj.get(n1)) {
                int n2 = nei[0], w2 = nei[1];
                minHeap.offer(new int[]{n2, w1+w2});
            }
        }

        for (int i=0; i < n; i++) {
            minPaths.putIfAbsent(i, -1);
        }

        return minPaths;
    }  
}
