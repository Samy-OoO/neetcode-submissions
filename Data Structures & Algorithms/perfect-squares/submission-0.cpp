class Solution {
public:
    int numSquares(int n) {
        vector<int> dp(n + 1, n);
        dp[0] = 0;

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s * s <= k; s++) {
                dp[k] = min(dp[k], 1 + dp[k - s*s]);
            }
        }
        return dp[n];
    }
};