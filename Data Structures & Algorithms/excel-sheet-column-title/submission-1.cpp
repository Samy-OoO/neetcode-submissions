class Solution {
public:
    string convertToTitle(int columnNumber) {
        unordered_map<int, char> l2N;
        for (int i = 0; i < 26; i++) {
            l2N[i] = 65 + i;
        }

        string res = "";
        while (columnNumber >= 1){
            columnNumber--;
            int rem = columnNumber % 26;
            res = l2N[rem] + res;
            columnNumber /= 26;
        }
        return res;
    }
};