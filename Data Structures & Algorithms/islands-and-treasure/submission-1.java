class Solution {
    int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    int rows, cols;

    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    bfs(grid, r, c, new boolean[rows][cols]);
                }
            }
        }
    }

    private void bfs(int[][] grid, int r, int c, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];

                if ((nr >= 0 && nr < rows) &&
                    (nc >= 0 && nc < cols) &&
                    (grid[nr][nc] > 0) && 
                    (!visited[nr][nc]))
                {
                    int dist = grid[row][col] + 1;
                    if (dist < grid[nr][nc]) grid[nr][nc] = dist;
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private int backtrack(int[][] grid, int r, int c, boolean[][] visited) {
        if ( (r < 0 || r >= rows) || (c < 0 || c >= cols) || 
             (grid[r][c] == -1) || 
             (visited[r][c])) return Integer.MAX_VALUE;
        if (grid[r][c] == 0) return 1;

        visited[r][c] = true;
        
        int min = Integer.MAX_VALUE;
        for (int[] dir : directions) {
            min = Math.min(min, backtrack(grid, r + dir[0], c + dir[1], visited));      
        }
        grid[r][c] = min;
        visited[r][c] = false;

        return grid[r][c] + 1;
    }
}
