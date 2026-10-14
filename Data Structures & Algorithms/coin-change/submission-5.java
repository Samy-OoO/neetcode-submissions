class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, -2);
        return dfs(coins, amount, 0);
    }

    private int dfs(int[] coins, int amt, int acc) {
        if (acc == amt) return dp[acc] = 0;
        if (dp[acc] != -2) return dp[acc];

        int dist = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin > amt || acc + coin > amt) continue;
            int path = dfs(coins, amt, acc + coin);
            if (path != -1) dist = Math.min(dist, path);
        }

        return dp[acc] = dist != Integer.MAX_VALUE ? dist+1 : -1;
    }
}