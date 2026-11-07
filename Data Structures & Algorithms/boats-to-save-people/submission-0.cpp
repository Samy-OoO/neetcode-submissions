class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end());
        int l = 0, r = people.size() - 1;
        int minBoats = 0;

        while (l <= r) {
            int wt = people[l] + people[r];
            if (wt <= limit) {
                l++;
                r--;
            } else r--;
            minBoats++;
        }

        return minBoats;
    }
};