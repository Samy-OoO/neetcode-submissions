class Solution {
public:
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {
        int edgeCount = edges.size();

        vector<vector<int>> e = edges;
        sort(e.begin(), e.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[2] < b[2];
        });

        vector<int> parentProto(n);
        vector<int> rankProto(n);

        for (int i = 0; i < n; i++) parentProto[i] = i;

        int minCost = 0, edgesUsed = 0;
        vector<int> parent = parentProto, rank = rankProto;
        for (vector<int>& edge : e) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (unify(u, v, parent, rank)) {
                minCost += w;
                if(++edgesUsed == n-1) break;
            }
        }

        vector<int> criticalEdges, pseudoCriticalEdges;
        for (int i = 0; i < edgeCount; i++) {
            int cost = 0;
            edgesUsed = 0;
            parent = parentProto;
            rank = rankProto;

            for (vector<int>& edge : e) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (u == edges[i][0] && v == edges[i][1]) continue;
                
                if (unify(u, v, parent, rank)) {
                    cost += w;
                    if(++edgesUsed == n-1) break;
                }
            }
            
            if (edgesUsed < n-1 || cost > minCost) criticalEdges.push_back(i);
        } 


        for (int i = 0; i < edgeCount; i++) {
            int cost = 0;
            edgesUsed = 0;
            parent = parentProto;
            rank = rankProto;

            if (std::find(criticalEdges.begin(), criticalEdges.end(), i) != criticalEdges.end()) continue;
            if (unify(edges[i][0], edges[i][1], parent, rank)) {
                cost += edges[i][2];
                edgesUsed++;
            }

            for (vector<int>& edge : e) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (u == edges[i][0] && v == edges[i][1]) continue;
                
                if (unify(u, v, parent, rank)) {
                    cost += w;
                    if(++edgesUsed == n-1) break;
                }
            }
            
            if (cost == minCost) pseudoCriticalEdges.push_back(i);
        }            

        vector<vector<int>> res;
        res.push_back(criticalEdges);
        res.push_back(pseudoCriticalEdges);
        return res;
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