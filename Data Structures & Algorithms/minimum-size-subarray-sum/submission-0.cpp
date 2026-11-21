class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int res = INT_MAX, l = 0, total = 0;

        for (int r = 0; r < nums.size(); r++) {
            total += nums[r];
            while (total >= target) {
                res = min(res, r-l+1);
                total -= nums[l];
                l++;
            }
        }

        return res == INT_MAX ? 0 : res;
    }
};