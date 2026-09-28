class Solution {
    int[][] directions = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pac);
            dfs(heights, rows-1, c, atl);
        }
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pac);
            dfs(heights, r, cols-1, atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) res.add(Arrays.asList(r, c));
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean) {
        ocean[r][c] = true;

        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];

            if ((nr >= 0 && nr < rows) &&
                (nc >= 0 && nc < cols) &&
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) 
            {
                dfs(heights, nr, nc, ocean);
            }
        }
    }

}
