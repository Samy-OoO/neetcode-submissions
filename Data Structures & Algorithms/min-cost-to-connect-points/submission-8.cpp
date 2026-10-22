class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();

        // Creating an edge list
        vector<tuple<int, int, int>> edges;

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i+1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = abs(x2-x1) + abs(y2-y1);
                edges.push_back({dist, i, j});            
            }
        }

        sort(edges.begin(), edges.end());

        vector<int> parent(n);
        vector<int> rank(n);

        for (int i = 0; i < n; i++) parent[i] = i;
        
        int cost = 0, edgesUsed = 0;

        for (tuple<int, int, int> edge : edges) {
            auto [w, u, v] = edge;
            if (unify(u, v, parent, rank)) {
                cost += w;
                edgesUsed++;

                if (edgesUsed == n-1) break;
            }
        }

        return cost;
    }


private:
    int find(int x, vector<int>& parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    bool unify(int a, int b, vector<int>& parent, vector<int>& rank) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) return false;
        if (rank[rootA] < rank[rootB]) parent[rootA] = rootB;
        else if (rank[rootB] < rank[rootA]) parent[rootB] = rootA;
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }
};
