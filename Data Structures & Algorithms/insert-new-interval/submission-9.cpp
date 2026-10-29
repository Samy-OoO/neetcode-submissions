class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        if (intervals.empty()) return {newInterval};

        int n = intervals.size();
        int target = newInterval[0];
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + (r-l)/2;
            if (intervals[mid][0] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        intervals.insert(intervals.begin() + l, newInterval);

        vector<vector<int>> res;
        for (const auto& interval : intervals) {
            if (res.empty() || res.back()[1] < interval[0]) res.push_back(interval);
            else res.back()[1] = max(res.back()[1], interval[1]);
        }
        return res;
    }
};
