class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end(), [](const vector<int>& a, const vector<int>& b) {
            return (long long)a[0] < (long long)b[0];
        });
        priority_queue<int, vector<int>, greater<int>> avail;
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> used;

        for (int i = 0; i < n; i++) avail.push(i);
        vector<int> count(n);

        for (const auto& meeting : meetings) {
            long long start = meeting[0], end = meeting[1];

            while (!used.empty() && used.top().first <= start) {
                int room = used.top().second;
                used.pop();
                avail.push(room);
            }
            if (avail.empty()) {
                auto cur = used.top(); used.pop();
                end = cur.first + (end - start);
                avail.push(cur.second);
            }

            int room = avail.top(); avail.pop();
            used.push({end, room});
            count[room]++;
        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) maxRoom = i;
        }
        return maxRoom;
    }
};