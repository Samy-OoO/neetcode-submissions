class Solution {
    int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    int rows, cols;

    public int islandPerimeter(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;  

        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if (grid[r][c] == 1) return bfs(grid, r, c);
            }
        }
        return 0;    
    }

    private int bfs(int[][] grid, int r, int c) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();

        int[] cell = new int[]{r, c};
        q.offer(cell);
        visited[r][c] = true;
        int perimeter = 0;

        while (!q.isEmpty()) {
            cell = q.poll();
            int row = cell[0], col = cell[1];

            for (int dir[] : directions) {
                int nr = row + dir[0], nc = col + dir[1];

                if ( (nr < 0 || nr >= rows) ||
                     (nc < 0 || nc >= cols) || 
                     (grid[nr][nc] == 0) )
                {
                    perimeter++;
                } else if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return perimeter;
    }
}