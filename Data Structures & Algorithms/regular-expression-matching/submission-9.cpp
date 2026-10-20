class Solution {
public:
    vector<vector<int>> memo;
    int m, n;
    bool isMatch(string s, string p) {
        m = s.size();
        n = p.size();
        memo = vector<vector<int>>(m+1, vector<int>(n+1, -1));
        return dfs(0, 0, s, p);
    }

private:
    bool dfs(int i, int j, const string& s, const string& p) {
        if (i >= m && j >= n) return true;
        else if (i < m && j >= n) return false;

        if (i <= m && j <= n && memo[i][j] != -1) return memo[i][j];

        bool match = i < m && (s[i] == p[j] || p[j] == '.');
        bool res;
        if (j+1 < n && p[j+1] == '*') {
            res = dfs(i, j+2, s, p) || (match && dfs(i+1, j, s, p));
        } else {
            res = match && dfs(i+1, j+1, s, p);
        }

        return memo[i][j] = res ? 1 : 0;
    }
};

