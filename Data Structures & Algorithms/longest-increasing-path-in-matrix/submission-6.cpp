class Solution {
public:
    vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> indegree(m, vector<int>(n, 0));
        int maxPath = 0;

        queue<pair<int, int>> q;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bool noIndeg = true;
                for (vector<int>& d : dirs) {
                    int ni = i+d[0], nj = j+d[1];
                     if (inbounds(ni, nj, matrix) &&
                        (matrix[ni][nj] < matrix[i][j]))
                        {
                            indegree[i][j]++;
                            noIndeg = false;
                        }
                }
                if (noIndeg) q.push({i, j});
            }
        }

        while (!q.empty()) {
            maxPath++;
            for (int k = q.size(); k > 0; k--) {
                pair<int, int> cell = q.front();
                q.pop();
                int i = cell.first, j = cell.second;
                
                for (vector<int>& d : dirs) {
                    int ni = i+d[0], nj = j+d[1];
                    if (inbounds(ni, nj, matrix) &&
                        (matrix[ni][nj] > matrix[i][j]))
                        {
                            indegree[ni][nj]--;
                            if (indegree[ni][nj] == 0) q.push({ni, nj});
                        }
                }
            }
        }

        return maxPath;
    }

private:
    bool inbounds(int i, int j, vector<vector<int>>& matrix){
        if ((i >= 0 && i < matrix.size()) &&
            (j >= 0 && j < matrix[0].size())) return true;
        return false;
    }
};
