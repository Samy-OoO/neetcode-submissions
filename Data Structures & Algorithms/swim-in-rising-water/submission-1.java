class Solution {
    int[][] directions = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        minHeap.offer(new int[]{0, 0, grid[0][0]});
        int max = 0;


        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int r = cell[0], c = cell[1], w = cell[2];
            visit[r][c] = true;

            max = Math.max(max, w);
            if (r == n-1 && c == n-1) return max;
            
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];

                if ((nr >= 0 && nr < n) &&
                    (nc >= 0 && nc < n) &&
                    (!visit[nr][nc])) 
                {
                    minHeap.offer(new int[]{nr, nc, grid[nr][nc]});
                }
            }
        }

        return max;     
    }
}
