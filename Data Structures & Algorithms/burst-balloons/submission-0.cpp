class Solution {
public:
    vector<vector<int>> memo;
    
    int maxCoins(vector<int>& nums) {

        vector<int> nums1;
        nums1.push_back(1);
        for (int i = 0; i < nums.size(); i++) {
            nums1.push_back(nums[i]);
        }
        nums1.push_back(1);

        int n = nums1.size();
        memo = vector<vector<int>>(n, vector<int>(n, -1));

        return dfs(1, n-2, nums1);
    }

private:
    int dfs(int l, int r, vector<int>& nums) {
        if (l > r) return 0;
        if (memo[l][r] != -1) return memo[l][r];

        int res = 0;
        for (int k = l; k <= r; k++) {
            int cur = nums[l-1] * nums[k] * nums[r+1] + dfs(l, k-1, nums) + dfs(k+1, r, nums);
            res = max(res, cur);
        }

        return memo[l][r] = res;
    }
};
