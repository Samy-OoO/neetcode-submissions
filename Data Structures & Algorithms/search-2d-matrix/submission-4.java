class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = null;

        for (int i=0; i<m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n-1]) {
                row = matrix[i];
                break;
            }
        }

        if (row == null) return false;

        int l=0;
        int r=n-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            int num = row[mid];

            if (target == num) return true;
            else if (target < num) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
