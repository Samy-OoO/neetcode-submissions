class Solution {
private:
    vector<bool> used;
    int target;
    bool backtrack(int i, int k, int subsetSum, vector<int>& nums) {
        if (k == 0) return true;
        if (subsetSum == target) return backtrack(0, k-1, 0, nums);

        for (int j = i; j < nums.size(); j++) {
            if (used[j] || subsetSum + nums[j] > target) continue;

            used[j] = true;
            if (backtrack(j+1, k, subsetSum + nums[j], nums)) return true;
            used[j] = false;
        }    

        return false;    
    }

public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        used = vector<bool>(nums.size(), false);
        target = sum / k;

        return backtrack(0, k, 0, nums);
    }
};