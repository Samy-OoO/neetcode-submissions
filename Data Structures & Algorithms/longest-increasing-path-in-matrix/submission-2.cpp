class Solution {
public:
    vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    vector<vector<int>> memo;

    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        set<pair<int, int>> vis;
        memo = vector<vector<int>>(m, vector<int>(n, -1));
        int maxPath = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = max(maxPath, dfs(i, j, vis, matrix));
            }
        }
        return maxPath;
    }

    int dfs(int i, int j, set<pair<int, int>>& vis, vector<vector<int>>& matrix) {
        if (memo[i][j] != -1) return memo[i][j];
        
        int res = 0;
        vis.insert({i, j});
        for (vector<int>& d : dirs) {
            int ni = i + d[0], nj = j + d[1];

            if ((ni >= 0 && ni < matrix.size()) &&
                (nj >= 0 && nj < matrix[0].size()) &&
                (matrix[ni][nj] > matrix[i][j]) &&
                vis.find({ni, nj}) == vis.end()) 
                {
                    if (memo[ni][nj] != -1) res = max(res, memo[ni][nj]);
                    res = max(res, dfs(ni, nj, vis, matrix));
                }
        }
        vis.erase({i, j});

        return memo[i][j] = res + 1;
    }
};
