class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Creating an Adjacency List for a weighted, undirected Graph.
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i=1; i <= n; i++) {
            adj.put(i, new LinkedList<>());
        }
        for (int[] time : times) {
            int src = time[0], dst = time[1], wt = time[2];
            adj.get(src).add(new int[]{dst, wt});
        }

        // Finding min. time to reach each node.
        Map<Integer, Integer> minTimes = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();
            int n1 = edge[0], w1 = edge[1];

            if (minTimes.containsKey(n1)) continue;
            minTimes.put(n1, w1);

            for (int[] nei : adj.get(n1)) {
                int n2 = nei[0], w2 = nei[1];
                minHeap.offer(new int[]{n2, w1+w2});
            }
        }

        for (int i=1; i <= n; i++) {
            if (!minTimes.containsKey(i)) return -1;
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : minTimes.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}
