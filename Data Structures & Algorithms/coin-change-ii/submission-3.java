class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[1][amount+1];
        int[][] cur = new int[1][amount+1];
        dp[0][0] = 1;
        cur[0][0] = 1; 
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                cur[0][j] = dp[0][j];
                if (j >= coins[i-1]) cur[0][j] += cur[0][j - coins[i-1]];
            }
            dp = cur;
        }

        return dp[0][amount];
    }
}
