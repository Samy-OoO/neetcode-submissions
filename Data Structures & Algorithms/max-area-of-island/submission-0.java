class Solution {
    int[][] directions = { {1, 0},{-1, 0},{0, 1},{0, -1} };
    int rows, cols;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int max = 0;

        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int area = bfs(grid, r, c);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 0;
        int area = 1;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                
                if ( (nr >= 0 && nr < rows) &&
                     (nc >= 0 && nc < cols) &&
                     (grid[nr][nc] == 1) )
                {
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                    area++;
                }
            }
        }

        return area;
    }
}
