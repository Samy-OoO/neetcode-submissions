class Solution {

private:
    vector<int> dp;

public:
    bool wordBreak(string s, vector<string>& wordDict) {
        dp = vector<int>(s.length() + 1, -1);
        return dfs(0, s, wordDict);
    }

private:
    bool dfs(int i, string& s, vector<string>& wordDict) {
        if (i >= s.length()) return true;
        if (dp[i] != -1) return dp[i] == 1;

        bool res = false;
        for(string& w : wordDict) {
            if (i + w.length() > s.length()) continue;

            if (s.substr(i, w.length()) == w) {
                res = res || dfs(i + w.length(), s, wordDict);
            }
        }

        dp[i] = res ? 1 : 0;
        return dp[i] == 1;
    }
};
