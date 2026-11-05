class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int i = 0, cur, count = 1, n = nums.size(), k = floor(n/3);
        set<int> res;

        while (i < n) {
            if (nums[i] == cur) count++;
            else {
                count = 1;
                cur = nums[i];
            }
            if (count > k) res.insert(cur);
            i++;
        }

        return vector<int>(res.begin(), res.end());
    }
};