class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> res;        
        sort(intervals.begin(), intervals.end());

        int i;
        for (i = 0; i < intervals.size(); i++) {
            if (intervals[i][0] > newInterval[0]) break;
            res.push_back(intervals[i]);
        }

        if (!res.empty() && res.back()[1] >= newInterval[0]) res.back()[1] = max(res.back()[1], newInterval[1]);
        else res.push_back(newInterval);

        for (int j = i; j < intervals.size(); j++) {
            int last = res.back()[1];
            if (last >= intervals[j][0]) res.back()[1] = max(last, intervals[j][1]);
            else res.push_back(intervals[j]);
        }

        return res;
    }
};
