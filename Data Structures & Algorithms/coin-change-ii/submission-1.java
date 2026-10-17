class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[m+1][amount+1];
        
        for (int i = 0; i <= m; i++) dp[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1]) dp[i][j] += dp[i][j - coins[i-1]];
            }
        }

        return dp[m][amount];
    }
}
