class Solution {
private:
    vector<vector<int>> memo;
    int total, target;

    int dfs(int i, int sum, vector<int>& stones) {
        if (sum >= target || i >= stones.size()) return abs(sum - (total - sum));
        if (memo[i][sum] != -1) return memo[i][sum];

        int take = dfs(i+1, sum + stones[i], stones);
        int skip = dfs(i+1, sum, stones);
        
        return memo[i][sum] = min(take, skip);
    }

public:
    int lastStoneWeightII(vector<int>& stones) {
        total = accumulate(stones.begin(), stones.end(), 0);
        target = (total+1) / 2;
        memo = vector<vector<int>>(stones.size() + 1, vector<int>(target+1, -1));
        return dfs(0, 0, stones);
    }
};