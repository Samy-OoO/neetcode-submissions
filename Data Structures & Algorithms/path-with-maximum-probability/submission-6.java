class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<double[]>> adj = new HashMap<>();
        for (int i=0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i=0; i < edges.length; i++) {
            int src = edges[i][0], dst = edges[i][1];
            adj.get(src).add(new double[]{dst, succProb[i]});
            adj.get(dst).add(new double[]{src, succProb[i]});
        }

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>( (a, b) -> Double.compare(b[1], a[1]) );
        maxHeap.offer(new double[]{start_node, 1});
        double[] best = new double[n];

        while (!maxHeap.isEmpty()) {
            double[] edge = maxHeap.poll();
            int n1 = (int) edge[0];
            double prob1 = edge[1];
            
            if (prob1 < best[n1]) continue;
            if (n1 == end_node) return best[n1];

            for (double[] nei : adj.get(n1)) {
                int n2 = (int) nei[0];
                double prob2 = nei[1], newProb = prob1 * prob2;
                
                if (newProb > best[n2]){
                    best[n2] = newProb;
                    maxHeap.offer(new double[]{n2, newProb});
                }
            }
        }

        return 0.0000;

    }
}