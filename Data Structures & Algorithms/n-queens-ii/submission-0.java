class Solution {
    int res = 0;
    Set<Integer> cols = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();

    public int totalNQueens(int n) {
        backtrack(0, n);
        return res;
    }

    private void backtrack(int r, int n) {
        if (r == n) {
            res++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || negDiag.contains(r-c) || posDiag.contains(r+c)) continue;

            cols.add(c);
            negDiag.add(r-c);
            posDiag.add(r+c);

            backtrack(r+1, n);

            cols.remove(c);
            negDiag.remove(r-c);
            posDiag.remove(r+c);
        }
    }
}