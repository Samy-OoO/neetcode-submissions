class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        int n = piles.size();
        vector<vector<vector<int>>> dp(2, vector<vector<int>>(n + 1, vector<int>(n + 1, 0)));

        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                int total = 0;
                dp[1][i][M] = 0;
                dp[0][i][M] = INT_MAX;
                
                for (int X = 1; X <= 2 * M; X++) {
                    if (i + X > n) break;
                    total += piles[i + X - 1];

                    dp[1][i][M] = max(dp[1][i][M], total + dp[0][i + X][max(M, X)]);
                    dp[0][i][M] = min(dp[0][i][M], dp[1][i + X][max(M, X)]);
                }
            }
        }

        return dp[1][0][1];
    }
};