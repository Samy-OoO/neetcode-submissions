class Solution {
private:
    unordered_map<char, int> getInt;

public:

    Solution() {
        getInt['I'] = 1;
        getInt['V'] = 5;
        getInt['X'] = 10;
        getInt['L'] = 50;
        getInt['C'] = 100;
        getInt['D'] = 500;
        getInt['M'] = 1000;
    }

    int romanToInt(string s) {
        int res = 0;
        
        for (int i = s.size() - 1; i >= 0; i--) {
            int cur = getInt[s[i]];
            int prev = i+1 < s.size() ? getInt[s[i+1]] : 0;

            if (cur < prev) res -= cur;
            else res += cur;
        }

        return res;
    }
};