class Solution {
    int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    int rows, cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(0, r, c, vis, board, word)) return true;
            }
        }

        return false;
    }

    private boolean backtrack(int idx, int r, int c, boolean[][] vis, char[][] board, String word) {
        if (idx == word.length()) return true;

        if ( r < 0 || c < 0 || r >= rows || c >= cols ||
            (board[r][c] != word.charAt(idx)) ||
            (vis[r][c]) ) return false; 

        vis[r][c] = true;       
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (backtrack(idx+1, nr, nc, vis, board, word)) return true;
        }
        vis[r][c] = false;

        return false;
    }
}
