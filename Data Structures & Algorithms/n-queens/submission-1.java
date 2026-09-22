class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int r, int n, char[][] board) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)) continue;
            
            board[r][c] = 'Q';
            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);

            backtrack(r+1, n, board);

            board[r][c] = '.';
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }
                
    }
}
