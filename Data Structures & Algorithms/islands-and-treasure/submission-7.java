class Solution {
    int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    int rows, cols;

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        rows = grid.length;
        cols = grid[0].length;

        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        if (q.isEmpty()) return;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            
            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];

                if ((nr >= 0 && nr < rows) &&
                    (nc >= 0 && nc < cols) &&
                    (grid[nr][nc] == Integer.MAX_VALUE) )
                {
                    grid[nr][nc] = grid[row][col] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    
}
