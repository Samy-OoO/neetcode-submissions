class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int k = nums.size() / 2;
        unordered_map<int, int> freqs;
        for (int num : nums) {
            freqs[num] = freqs[num] + 1;
            if (freqs[num] > k) return num;
        }
        return -1;
    }
};