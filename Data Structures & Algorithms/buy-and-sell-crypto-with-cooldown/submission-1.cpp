class Solution {
public:
    unordered_map<string, int> memo;
    int maxProfit(vector<int>& prices) {
        return dfs(0, true, prices);
    }

private:
    int dfs(int i, bool buying, vector<int>& prices) {
        if (i >= prices.size()) return 0;

        string key = to_string(i) + "-" + to_string(buying);
        if (memo.find(key) != memo.end()) return memo[key];

        int cooldown = dfs(i + 1, buying, prices);
        if (buying) {
            int buy = dfs(i + 1, false, prices) - prices[i];
            memo[key] = max(buy, cooldown);
        } else {
            int sell = dfs(i + 2, true, prices) + prices[i];
            memo[key] = max(sell, cooldown);
        }

        return memo[key];
    }
};
