class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int m = days.size();
        vector<int> dp(m+1);
        vector<int> durations = {1, 7, 30};
        dp[m] = 0;

        for (int i = m-1; i >= 0; i--) {
            int j = i;
            dp[i] = INT_MAX;
            for (int k = 0; k < 3; k++) {
                while ( j < days.size() && days[j] < days[i] + durations[k] ) j++;
                dp[i] = min(dp[i], costs[k] + dp[j]);
            }

        }

        return dp[0];
    }
};