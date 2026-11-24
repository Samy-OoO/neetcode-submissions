class Solution {
private:
    bool canShip(const vector<int>& weights, int days, int cap) {
        int ships = 1, curCap = cap;
        for (int w : weights) {
            if (curCap - w < 0) {
                ships++;
                if (ships > days) return false;
                curCap = cap;
            }
            curCap -= w;
        }
        return true;
    }

public:
    int shipWithinDays(vector<int>& weights, int days) {
        int l = *max_element(weights.begin(), weights.end());
        int r = accumulate(weights.begin(), weights.end(), 0);
        int res = r;

        while (l <= r) {
            int cap = (l + r) / 2;
            if (canShip(weights, days, cap)) {
                res = min(res, cap);
                r = cap - 1;
            } else l = cap + 1;
        }

        return res;
    }
};