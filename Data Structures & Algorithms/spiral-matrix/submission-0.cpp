class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        int m = matrix.size(), n = matrix[0].size();
        int l = 0, r = matrix[0].size() - 1, top = 0, bottom = matrix.size() - 1;

        while (l <= r && top <= bottom) {

            for (int i = l; i <= r && top <= bottom; i++) res.push_back(matrix[top][i]);
            top++;

            for (int i = top; i <= bottom && l <= r; i++) res.push_back(matrix[i][r]);
            r--;

            for (int i = r; i >= l && top <= bottom; i--) res.push_back(matrix[bottom][i]);
            bottom--;
            
            for (int i = bottom; i >= top && l <= r; i--) res.push_back(matrix[i][l]);
            l++;
        }

        return res;
    }
};
