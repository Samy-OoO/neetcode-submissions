class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[] dp = new int[amount+1];
        int[] cur = new int[amount+1];
        dp[0] = 1;
        cur[0] = 1; 
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                cur[j] = dp[j];
                if (j >= coins[i-1]) cur[j] += cur[j - coins[i-1]];
            }
            dp = cur;
        }

        return dp[amount];
    }
}
