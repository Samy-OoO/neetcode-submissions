class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();

        // Create Graph
        vector<vector<pair<int, int>>> adj(n);

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];

            for (int j = i+1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = abs(x2-x1) + abs(y2-y1);

                adj[i].push_back({dist, j});
                adj[j].push_back({dist, i});
            }
        }

        vector<bool> vis(n, false);

        priority_queue<
            pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>
        > minHeap;
        minHeap.push({0, 0});
        int cost = 0, edgesUsed = 0;

        while(!minHeap.empty() && edgesUsed < n) {
            pair<int, int> edge = minHeap.top();
            minHeap.pop();
            int node = edge.second, dist = edge.first;

            if (vis[node]) continue;

            vis[node] = true;
            cost += dist;
            edgesUsed++;

            for (pair<int, int>& nei : adj[node]) {
                if (!vis[nei.second]) minHeap.push({nei.first, nei.second});
            }
        }

        return cost;
    }
};
