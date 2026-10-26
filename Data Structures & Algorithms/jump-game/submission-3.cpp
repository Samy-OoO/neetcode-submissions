class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        vector<bool> dp(n, false);
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            int steps = nums[i];
            while (steps > 0) {
                dp[i + steps] = true;
                steps--;
            }
        }

        return dp[n-1];
        
    }
};
