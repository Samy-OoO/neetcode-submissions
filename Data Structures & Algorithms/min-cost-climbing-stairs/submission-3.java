class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(dfs(0, cost), dfs(1, cost));
    }

    private int dfs(int i, int[] cost) {
        if (i >= cost.length) return 0;
        if (dp[i] != -1) return dp[i];
        return dp[i] = cost[i] + Math.min(dfs(i+1, cost), dfs(i+2, cost));    
    }
}
