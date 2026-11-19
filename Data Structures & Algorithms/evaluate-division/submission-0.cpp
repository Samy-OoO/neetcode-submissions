class Solution {
private:
    double bfs(const string& src, const string& target, unordered_map<string, vector<pair<string, double>>>& adj) {
        if (!adj.count(src) || !adj.count(target)) return -1.0;

        queue<pair<string, double>> q;
        unordered_set<string> vis;
        q.emplace(src, 1.0);
        vis.insert(src);

        while(!q.empty()) {
            auto [node, wt] = q.front(); q.pop();

            if (node == target) return wt;

            for (const auto& [nei, neiWt] : adj[node]) {
                if (!vis.count(nei)) {
                    vis.insert(nei);
                    q.emplace(nei, wt * neiWt);
                }
            }
        }

        return -1.0;
    }

public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        // Map a -> list of [b, a/b]
        unordered_map<string, vector<pair<string, double>>> adj;

        for (int i = 0; i < equations.size(); i++) {
            string a = equations[i][0], b = equations[i][1];
            adj[a].emplace_back(b, values[i]);
            adj[b].emplace_back(a, 1.0 / values[i]);
        }

        vector<double> res;
        for (const auto& query : queries) {
            string src = query[0], target = query[1];
            res.push_back(bfs(src, target, adj));
        }

        return res;
    }
};