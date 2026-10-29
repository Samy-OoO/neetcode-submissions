class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> res;
        res.push_back(intervals[0]);

        for (auto& interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int lastEnd = res.back()[1];

            if (start <= lastEnd) res.back()[1] = max(lastEnd, end);
            else res.push_back({start, end});
        }

        return res;
    }
};
