class Solution {
    int[][] directions = { {1, 0},{-1, 0},{0, 1},{0, -1} };
    int rows, cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int islands = 0;

        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs (char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int[] dir : directions) {
                int nr = cell[0] + dir[0], nc = cell[1] + dir[1];
                
                if ( (nr >= 0 && nr < rows) &&
                     (nc >= 0 && nc < cols) && 
                     (grid[nr][nc] == '1'))
                {
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
