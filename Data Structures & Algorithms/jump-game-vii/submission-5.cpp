class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        int n = s.size();
        if (s[n-1] == '1') return false;
        int far = 0;

        queue<int> q;
        q.push(0);

        while (!q.empty()) {
            int i = q.front(); q.pop();
            int start = max(i + minJump, far + 1);

            for (int j = start; j <= min(i + maxJump, n-1); j++) {
                if (s[j] == '1') continue;

                q.push(j);
                if (j == n-1) return true;
            }
            far = i + maxJump;
        }
        
        return false;
    }
};