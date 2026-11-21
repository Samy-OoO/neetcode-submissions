class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        int n = s.size();
        if (s[n-1] == '1') return false;

        queue<int> q;
        q.push(0);

        vector<bool> dp(n, false);
        dp[0] = true;

        while (!q.empty()) {
            int i = q.front(); q.pop();

            if (i == n-1) return true;

            for (int j = i + minJump; j <= i + maxJump; j++) {
                if (j > n-1) break;
                if (s[j] == '1') continue;
                if (!dp[j]) {
                    q.push(j);
                    dp[j] = true;
                }
            }
        }
        
        return false;
    }
};