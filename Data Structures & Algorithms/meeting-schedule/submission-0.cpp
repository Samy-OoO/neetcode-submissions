/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    bool canAttendMeetings(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const Interval& a, const Interval& b) {
            return a.start < b.start;
        });

        for (int i = 1; i < intervals.size(); i++) {
            Interval& cur = intervals[i];
            Interval& prev = intervals[i-1];

            if (cur.start < prev.end) return false;
        }

        return true;
    }
};
