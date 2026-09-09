class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int idx = -1;
        int[] row;

        for (int i=0; i<n; i++) {
            int l = 0, r = m-1;
            if (matrix[i][l] <= target && matrix[i][r] >= target){
                idx = i;
                break;
            }
        }

        if (idx == -1) return false;

        row = matrix[idx];
        int l = 0, r = row.length-1, mid, num;

        while (l <= r) {
            mid = l + (r-l)/2;
            num = row[mid];

            if (num == target) return true;
            else if (num < target) l = mid + 1;
            else r = mid - 1;
        }
        
        return false;

    }
}
