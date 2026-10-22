class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int rows = heights.size(), cols = heights[0].size();
        vector<vector<int>> directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        int res = 0;
        set<pair<int, int>> vis;
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> minHeap;
        minHeap.push({0,0,0});

        while (!minHeap.empty()) {
            vector<int> cell = minHeap.top();
            minHeap.pop();
            int x1 = cell[1], y1 = cell[2], diff = cell[0];

            res = max(res, diff);
            if (vis.contains({x1, y1})) continue;
            vis.insert({x1, y1});

            if (x1 == rows-1 && y1 == cols-1) break;

            for (vector<int>& dir : directions) {
                int x2 = x1 + dir[0], y2 = y1 + dir[1];
                if ((x2 >= 0 && x2 < rows) &&
                    (y2 >= 0 && y2 < cols)) minHeap.push({abs(heights[x2][y2] - heights[x1][y1]), x2, y2});
            }
        }

        return res;
    }
};