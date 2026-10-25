class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0], curSum = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            curSum = max(curSum, 0) + nums[i];
            res = max(curSum, res);
        }

        return res;
    }
};
