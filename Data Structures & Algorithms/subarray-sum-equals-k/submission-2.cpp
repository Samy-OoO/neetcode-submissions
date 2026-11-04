class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> prefixSums;
        prefixSums[0] = 1;
        int count = 0, sum = 0;

        for (int num : nums) {
            sum += num;
            count += prefixSums[sum - k];
            prefixSums[sum] += 1;
        }

        return count;        
    }
};