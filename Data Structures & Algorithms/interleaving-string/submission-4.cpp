class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int m = s1.size(), n = s2.size();
        if (s3.size() != m+n) return false;
        
        vector<vector<bool>> dp(m + 1, vector<bool>(n + 1, false));
        dp[0][0] = true;
        
        for (int k = 1; k <= m; k++) {
            if (s1[k-1] == s3[k-1] && dp[k-1][0]) dp[k][0] = true;
        }
        for (int k = 1; k <= n; k++) {
            if (s2[k-1] == s3[k-1] && dp[0][k-1]) dp[0][k] = true;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                bool s1Match = s3[i+j-1] == s1[i-1] && dp[i-1][j];
                bool s2Match = s3[i+j-1] == s2[j-1] && dp[i][j-1];
                dp[i][j] = s1Match || s2Match;
            }
        }

        return dp[m][n];
    }
};
