class Solution {
private:
    vector<int> memo;
    int dfs(vector<int>& nums, int total) {
        if (memo[total] != -1) return memo[total];
        int res = 0;
        for (int num : nums) {
            if (total < num) break;
            res += dfs(nums, total - num);
        }
        return memo[total] = res;
    }

public:
    int combinationSum4(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        memo = vector<int>(target + 1, -1);
        memo[0] = 1;
        return dfs(nums, target);
    }
};