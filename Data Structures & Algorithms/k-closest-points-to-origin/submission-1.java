class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int[] point : points) {
            int distance = (int)(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            minHeap.offer(new int[]{distance, point[0], point[1]});
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (i < k) {
            int[] entry = minHeap.poll();
            res[i] = new int[]{entry[1], entry[2]};
            i++;
        }

        return res;
    }
}
