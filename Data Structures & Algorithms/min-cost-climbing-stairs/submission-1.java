class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(n, cost);
    }

    private int dfs(int i, int[] cost) {
        if (i <= 1) return 0;
        if (dp[i] != -1) return dp[i];
        return dp[i] = Math.min(dfs(i-1, cost) + cost[i-1], dfs(i-2, cost) + cost[i-2]);
    }
}
