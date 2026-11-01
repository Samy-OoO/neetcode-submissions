class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int l = 0, r = matrix.size() - 1;

        while (l < r) {
            for (int i = 0; i < r-l; i++) {
                int top = l, bot = r;

                // save the topLeft
                int topLeft = matrix[top][l + i];
                
                matrix[top][l + i] = matrix[bot - i][l];
                matrix[bot - i][l] = matrix[bot][r - i];
                matrix[bot][r - i] = matrix[top + i][r];
                matrix[top + i][r] = topLeft;
            }
            l++;
            r--;
        }
    }
};
