class Solution {
    struct DSU {
        vector<int> p, r;

        DSU(int n) : p(n), r(n, 0) {
            iota(p.begin(), p.end(), 0);
        }

        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        bool unite(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;

            if (r[a] < r[b]) swap(a, b);
            p[b] = a;
            if (r[a] == r[b]) r[a]++;
            return true;
        }
    };

    int kruskal(int n, vector<vector<int>>& edges,
                int skip = -1, int force = -1) {
        DSU dsu(n);
        int cost = 0, used = 0;

        if (force != -1) {
            auto& e = edges[force];
            if (dsu.unite(e[0], e[1])) {
                cost += e[2];
                used++;
            }
        }

        for (int i = 0; i < edges.size(); i++) {
            if (i == skip || i == force) continue;

            auto& e = edges[i];
            if (dsu.unite(e[0], e[1])) {
                cost += e[2];
                if (++used == n - 1) break;
            }
        }

        return used == n - 1 ? cost : INT_MAX;
    }

public:
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(
        int n, vector<vector<int>>& edges) {

        int m = edges.size();
        vector<vector<int>> e(m);

        for (int i = 0; i < m; i++)
            e[i] = {edges[i][0], edges[i][1], edges[i][2], i};

        sort(e.begin(), e.end(),
             [](const auto& a, const auto& b) {
                 return a[2] < b[2];
             });

        vector<vector<int>> sorted(m, vector<int>(3));
        vector<int> originalIndex(m);

        for (int i = 0; i < m; i++) {
            sorted[i] = {e[i][0], e[i][1], e[i][2]};
            originalIndex[i] = e[i][3];
        }

        int minCost = kruskal(n, sorted);
        vector<int> critical, pseudo;

        for (int i = 0; i < m; i++) {
            int costWithout = kruskal(n, sorted, i);
            if (costWithout > minCost) critical.push_back(originalIndex[i]);
            else if (kruskal(n, sorted, -1, i) == minCost)
                pseudo.push_back(originalIndex[i]);
        }

        return {critical, pseudo};
    }
};