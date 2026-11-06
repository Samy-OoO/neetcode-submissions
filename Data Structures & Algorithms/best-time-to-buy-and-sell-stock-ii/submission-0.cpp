class Solution {
private:
    unordered_map<string, int> memo;
    int dfs(vector<int>& prices, int i, bool held) {
        if (i >= prices.size()) return 0;

        string key = to_string(i) + "-" + to_string(held);
        if (memo.find(key) != memo.end()) return memo[key];        

        int wait = dfs(prices, i+1, held);
        int transact = held ? dfs(prices, i+1, false) + prices[i]
                            : dfs(prices, i+1, true) - prices[i];

        return memo[key] = max(wait, transact);
    }

public:
    int maxProfit(vector<int>& prices) {
        return dfs(prices, 0, false);
    }
};