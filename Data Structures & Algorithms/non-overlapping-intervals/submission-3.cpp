class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        
        int prevEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.size(); i++) {
            vector<int>& cur = intervals[i];
            if (cur[0] < prevEnd) {
                prevEnd = min(prevEnd, cur[1]);
                count++;
            }
            else prevEnd = cur[1];
        }

        return count;
    }
};
