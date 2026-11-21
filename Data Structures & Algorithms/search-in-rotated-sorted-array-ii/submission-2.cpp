class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int l = 0, r = nums.size()-1;

        while (l <= r) {
            int m = l + (r-l)/2;
            int mid = nums[m], left = nums[l], right = nums[r];

            if (mid == target) return true;

            if (left < mid) {
                if (left <= target && target < mid) r = m - 1;
                else l = m + 1;
            }
            else if (left > mid) {
                if (mid < target && target <= right) l = m + 1;
                else r = m - 1;
            } else l++;
        } 

        return false;
    }
};