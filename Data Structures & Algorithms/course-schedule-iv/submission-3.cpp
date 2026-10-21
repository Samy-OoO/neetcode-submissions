class Solution {
public:
    
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        vector<int> indegree(numCourses, 0);        
        unordered_map<int, vector<int>> adj;
        for (vector<int>& pre : prerequisites) {
            int u = pre[0], v = pre[1];
            adj[u].push_back(v);
            adj[v];
            indegree[v]++;
        }

        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.push(i);
        }

        vector<unordered_set<int>> isPrereq(numCourses);
        while(!q.empty()) {
            int node = q.front(); q.pop();

            for (int nei : adj[node]) {
                isPrereq[nei].insert(node);
                isPrereq[nei].insert(isPrereq[node].begin(), isPrereq[node].end());
                if (--indegree[nei] == 0) q.push(nei);
            }
        }

        vector<bool> res;
        for (vector<int>& query : queries) {
            res.push_back(isPrereq[query[1]].count(query[0]));
        }

        return res;        
    }
};