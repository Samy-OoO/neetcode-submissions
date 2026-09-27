class Solution {
    int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    int rows, cols;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        rows = grid.length;
        cols = grid[0].length;
        boolean ones = false;
        int t=0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) q.offer(new int[]{r, c, t});
                if (grid[r][c] == 1) ones = true;
            }
        }
        
        if (!ones) return t;
        if (q.isEmpty()) return -1;
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            t = cell[2];

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];

                if ((nr >= 0 && nr < rows) &&
                    (nc >= 0 && nc < cols) &&
                    (grid[nr][nc] == 1)) 
                {
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc, t+1});
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) return -1;
            }
        }

        return t;
    }

    private void checkIso(int[][] grid, int r, int c) {
        for (int[] dir : directions) {
            int nr = r + dir[0] + dir[1];
        }
    }
}
