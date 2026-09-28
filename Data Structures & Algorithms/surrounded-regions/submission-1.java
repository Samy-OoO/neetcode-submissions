class Solution {
    int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    int rows, cols;
    boolean[][] regions;

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        regions = new boolean[rows][cols];

        for (int c=0; c < cols; c++) {
            if (board[0][c] == 'O') dfs(0, c, board);
            if (board[rows-1][c] == 'O') dfs(rows-1, c, board);
        }
        for (int r=0; r < rows; r++) {
            if (board[r][0] == 'O') dfs(r, 0, board);
            if (board[r][cols-1] == 'O') dfs(r, cols-1, board);
        }

        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if (!regions[r][c]) board[r][c] = 'X';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        regions[r][c] = true;

        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];

            if ((nr >= 0 && nr < rows) &&
                (nc >= 0 && nc < cols) &&
                !regions[nr][nc] && board[nr][nc] == 'O') 
            {
                dfs(nr, nc, board);                
            }
        }
    }
}
