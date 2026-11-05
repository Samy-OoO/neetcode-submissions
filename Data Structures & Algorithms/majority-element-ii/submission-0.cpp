class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> res;
        int n = nums.size(), k = n/3;
        
        unordered_map<int, int> countMap;
        for (int i = 0; i < n; i++) {
            countMap[nums[i]]++;
        }
        for (auto& entry : countMap) {
            if (entry.second > k) res.push_back(entry.first);
        }
        return res;
    }
};