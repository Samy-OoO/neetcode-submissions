class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i=0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        // edge = (src, dst, weight)
        for (List<Integer> edge : edges) {
            int sc = edge.get(0), dst = edge.get(1), wt = edge.get(2);
            adj.get(sc).add(new int[]{dst, wt});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{src, 0});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int n1 = cur[0], w1 = cur[1];

            if (shortest.containsKey(n1)) continue;
            shortest.put(n1, w1);

            for (int[] edge : adj.get(n1)) {
                int n2 = edge[0], w2 = edge[1];
                if (!shortest.containsKey(n2)){
                    minHeap.offer(new int[]{n2, w1+w2});
                }
            }
        }

        for (int i=0; i < n; i++) {
            if (!shortest.containsKey(i)) shortest.putIfAbsent(i, -1);
        }

        return shortest;
    }  
}
