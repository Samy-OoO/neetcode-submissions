class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        backtrack(0, board, n);
        return res;
    }

    private void backtrack(int r, char[][] board, int n) {
        if (r == n) {
            List<String> curBoard = new ArrayList<>();
            for (char[] row : board) {
                curBoard.add(new String(row));
            }
            res.add(curBoard);
            return;
        }


        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)) continue;

            board[r][c] = 'Q';
            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);

            backtrack(r+1, board, n);

            board[r][c] = '.';
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }
    }
}
