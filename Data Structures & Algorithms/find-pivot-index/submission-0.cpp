class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int n = nums.size();
        vector<int> prefixSums(n+1, 0);

        for (int i = 1; i <= n; i++) {
            prefixSums[i] = nums[i-1] + prefixSums[i-1];
        }

        for (int i = 1; i <= n; i++) {
            if (prefixSums[i-1] == prefixSums[n] - prefixSums[i]) return i-1;
        }

        return -1;
    }
};