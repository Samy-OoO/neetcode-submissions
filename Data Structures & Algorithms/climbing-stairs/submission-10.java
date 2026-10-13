class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fib(n, 0);
    }

    private int fib(int n, int i) {
        if (i >= n) return i == n ? 1 : 0;
        if (dp[i] != -1) return dp[i]; 
        return dp[i] = fib(n, i+1) + fib(n, i+2);
    }
}
