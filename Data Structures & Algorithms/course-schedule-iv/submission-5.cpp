class Solution {
public:
    vector<vector<int>> dependency;
    unordered_map<int, vector<int>> adj;
    
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        for (vector<int>& pre : prerequisites) {
            int u = pre[0], v = pre[1];
            adj[v].push_back(u);
            adj[u];
        }

        dependency = vector<vector<int>>(numCourses, vector<int>(numCourses, -1));
        vector<bool> res;
        unordered_set<int> path;
        for (vector<int>& query : queries) {
            res.push_back(dfs(query[1], query[0], path));
        }

        return res;        
    }

    bool dfs(int node, int target, unordered_set<int>& path) {
        if (node == target) return true;
        if (adj[node].empty() || path.contains(node)) return false;
        if (dependency[node][target] != -1) return dependency[node][target];

        path.insert(node);
        bool res = 0;
        for (int nei : adj[node]) {
            res = res || dfs(nei, target, path);
        }
        path.erase(node);

        return dependency[node][target] = res;
    }
};