class Solution {
public:
    string convertToTitle(int columnNumber) {
        string res = "";
        while (columnNumber >= 1){
            columnNumber--;
            int rem = columnNumber % 26;
            res = static_cast<char>(65 + rem) + res;
            columnNumber /= 26;
        }
        return res;
    }
};