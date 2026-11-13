class Solution {
private:
    vector<vector<int>> memo;
    int dfs(vector<int>& piles, int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        bool even = (j-i) % 2 == 0;
        int left = even ? piles[i] : 0;
        int right = even ? piles[j] : 0;

        return memo[i][j] = max(dfs(piles, i+1, j) + left, dfs(piles, i, j-1) + right);
    }

public:
    bool stoneGame(vector<int>& piles) {
        int n = piles.size();
        memo = vector<vector<int>>(n, vector<int>(n, -1));
        int total = accumulate(piles.begin(), piles.end(), 0);
        int alice = dfs(piles, 0, n-1);
        return alice > total - alice;
    }
};