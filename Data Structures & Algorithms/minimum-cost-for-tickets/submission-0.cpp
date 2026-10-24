class Solution {
public:
    vector<int> durations = {1, 7, 30};
    vector<int> memo;
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int m = days.size();
        memo = vector<int>(m+1, INT_MAX);
        memo[m] = 0;
        return dfs(0, days, costs);
    }

private:
    int dfs(int i, vector<int>& days, vector<int>& costs) {
        if (memo[i] != INT_MAX) return memo[i];
        
        int res = INT_MAX;
        for (int k = 0; k < 3; k++) {
            int j = i;
            while (j < days.size() && days[j] < days[i] + durations[k]) j++;
            res = min(res, costs[k] + dfs(j, days, costs));
        }

        return memo[i] = res;
    }
};