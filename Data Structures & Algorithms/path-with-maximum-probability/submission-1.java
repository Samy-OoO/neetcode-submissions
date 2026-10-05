class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<double[]>> adj = new HashMap<>();
        for (int i=0; i < n; i++) {
            adj.put(i, new LinkedList<>());
        }
        for (int i=0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj.get(edge[0]).add(new double[]{edge[1], succProb[i]});
            adj.get(edge[1]).add(new double[]{edge[0], succProb[i]});
        }

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>( (a, b) -> Double.compare(b[1], a[1]) );
        maxHeap.offer(new double[]{start_node, 1});
        double[] res = new double[n];

        while (!maxHeap.isEmpty()) {
            double[] edge = maxHeap.poll();
            int n1 = (int) edge[0];
            double w1 = edge[1];
            
            if (res[n1] != 0) continue;
            res[n1] = w1;

            for (double[] nei : adj.get(n1)) {
                int n2 = (int) nei[0];
                double w2 = nei[1];

                maxHeap.offer(new double[]{n2, w1*w2});
            }
        }

        return res[end_node];

    }
}