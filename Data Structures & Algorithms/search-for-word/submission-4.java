class Solution {
    int rows, cols;
    Set<Pair<Integer, Integer>> cells = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (backtrack(r, c, 0, board, word)) return true;
            }
        }  

        return false;      
    }

    private boolean backtrack(int r, int c, int i, char[][] board, String word) {
        if (i == word.length()) return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols ||
            board[r][c] != word.charAt(i) ||
            cells.contains(new Pair(r, c))) return false;
        
        cells.add(new Pair(r, c));

        boolean res = (backtrack(r+1, c, i+1, board, word) ||
                       backtrack(r-1, c, i+1, board, word) ||
                       backtrack(r, c+1, i+1, board, word) ||
                       backtrack(r, c-1, i+1, board, word));

        cells.remove(new Pair(r, c));

        return res;
    }
}
