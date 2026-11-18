class Solution {
private:
    vector<int> sides = vector<int>(4, 0);
    int len;

    bool backtrack(int i, vector<int>& mat) {
        if (i == mat.size()) return true;

        for (int j = 0; j < 4; j++) {
            if (sides[j] + mat[i] <= len) {
                sides[j] += mat[i];
                if (backtrack(i+1, mat)) return true;
                sides[j] -= mat[i];
            }
        }
        return false;
    }

public:
    bool makesquare(vector<int>& matchsticks) {
        int total = accumulate(matchsticks.begin(), matchsticks.end(), 0);
        len = total / 4;
        if (total % 4 != 0) return false;

        sort(matchsticks.begin(), matchsticks.end(), greater<int>());
        return backtrack(0, matchsticks);
    }
};