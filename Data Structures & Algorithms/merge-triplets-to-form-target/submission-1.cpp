class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < triplets.size(); j++) {
                if (target[i] < triplets[j][i]) {
                    triplets.erase(triplets.begin() + j); 
                    j--;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            bool found = false;
            for (int j = 0; j < triplets.size(); j++) {
                if (target[i] == triplets[j][i]) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }

        return true;
    }
};
