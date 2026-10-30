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
    int minMeetingRooms(vector<Interval>& intervals) {
        if (intervals.empty()) return 0;
        vector<int> startTimes, endTimes;
        for (Interval& i : intervals) {
            startTimes.push_back(i.start);
            endTimes.push_back(i.end);
        }
        sort(startTimes.begin(), startTimes.end());
        sort(endTimes.begin(), endTimes.end());

        int s = 0, e = 0, count = 0, maxRooms = 0;
        while(s < intervals.size()) {
            if (endTimes[e] <= startTimes[s]) {
                maxRooms = max(maxRooms, count);
                e++;
                count--;
            } 
            s++;
            count++;
        }
        maxRooms = max(maxRooms, count);

        return maxRooms;
    }
};
