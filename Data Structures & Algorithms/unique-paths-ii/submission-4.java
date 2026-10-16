class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        for (int k = 0; k < m; k++) {
            if (obstacleGrid[k][0] == 1) break;
            dp[k][0] = 1;
        }
        for (int k = 0; k < n; k++) {
            if (obstacleGrid[0][k] == 1) break;
            dp[0][k] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i-1][j] + dp[i][j-1] : 0;
            }
        }

        return dp[m-1][n-1];
    }
}