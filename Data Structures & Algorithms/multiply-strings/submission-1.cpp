class Solution {
public:
    string multiply(string num1, string num2) {
        if (num1 == "0" || num2 == "0") return "0";
        if (num1.size() < num2.size()) swap(num1, num2);

        int m = num1.size(), n = num2.size();
        vector<int> res(m + n, 0);

        reverse(num1.begin(), num1.end());
        reverse(num2.begin(), num2.end());
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int prod = (res[i + j] + (num1[i] - '0') * (num2[j] - '0'));
                res[i + j] = prod % 10;
                res[i + j + 1] += prod / 10;
            }
        }

        reverse(res.begin(), res.end());
        int i = 0;
        while (i < m + n && res[i] == 0) i++;

        string prod;
        for (i; i < (m + n); i++) prod += to_string(res[i]);

        return prod;
    }
};
