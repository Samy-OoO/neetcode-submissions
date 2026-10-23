class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        vector<vector<bool>> exists(numCourses, vector<bool>(numCourses, false));

        for (vector<int>& pre : prerequisites) {
            exists[pre[1]][pre[0]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    exists[i][j] = exists[i][j] || (exists[k][j] && exists[i][k]);
                }
            }
        }

        vector<bool> res;
        for (vector<int>& query : queries) {
            res.push_back(exists[query[1]][query[0]]);
        }

        return res;
    }
};