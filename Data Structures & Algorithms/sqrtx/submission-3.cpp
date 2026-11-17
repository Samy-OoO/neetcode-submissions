class Solution {
public:
    int mySqrt(int x) {
        int l = 0, r = x;
        int res = 0;

        while(l <= r) {
            int m = l + (r - l) / 2;
            long long p = pow(m, 2);
            if (p > x) r = m - 1;
            else if (p < x) {
                l = m + 1;
                res = m;
            }
            else return m;
        }

        return res;
    }
};