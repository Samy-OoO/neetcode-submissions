class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<int>> dist(n, vector<int>(n, INT_MAX/2));

        for (int i = 0; i < n; i++) dist[i][i] = 0;

        for (vector<int>& time : times) {
            int u = time[0]-1, v = time[1]-1, w = time[2];
            dist[u][v] = w;
        }

        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = min(dist[i][j], dist[i][l] + dist[l][j]);
                }
            }
        }

        int res = *max_element(dist[k-1].begin(), dist[k-1].end());
        return res == INT_MAX/2 ? -1 : res;
    }
};
