class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            int s = flight[0], d = flight[1], w = flight[2];
            adj.computeIfAbsent(s, key -> new LinkedList<>()).add(new int[]{d, w});
            adj.computeIfAbsent(d, key -> new LinkedList<>());
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{src, 0, k});

        while(!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();
            int n1 = edge[0], w1 = edge[1], k1 = edge[2];

            if (n1 == dst) return w1;

            for (int[] nei : adj.get(n1)) {
                int n2 = nei[0], w2 = nei[1];
                if ((k1 != 0) || (k1 == 0 && n2 == dst)) minHeap.offer(new int[]{n2, w1+w2, k1-1});
            }
        }

        return -1;
    }
}
