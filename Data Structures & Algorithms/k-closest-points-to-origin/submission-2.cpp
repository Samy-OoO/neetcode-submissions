class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        priority_queue<pair<int, int>> maxH;
        for (int i = 0; i < points.size(); i++) {
            int dist = pow(points[i][0], 2) + pow(points[i][1], 2);
            maxH.push({dist, i});
        }

        while (maxH.size() > k) maxH.pop();

        vector<vector<int>> res;
        while (!maxH.empty()) {
            pair<int, int> p = maxH.top(); maxH.pop();
            vector<int> point = points[p.second];
            res.push_back(point);
        }

        return res;
    }
};
