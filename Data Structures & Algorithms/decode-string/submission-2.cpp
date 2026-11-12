class Solution {
public:
    string decodeString(string s) {
        int i = 0, start, count = 0, n;
        string res = "";

        while (i < s.size()) {
            char ch = s[i];
            if (ch-'0' >= 0 && ch-'0' <= 9) {
                string subS;
                while (s[i] != '[') subS += s[i++];
                if (count++ == 0) {
                    start = i+1;
                    n = stoi(subS);
                }
            }
            if (s[i] == ']') {
                if (--count == 0) {
                    string str = decodeString(s.substr(start, i-start));
                    for (int i = 0; i < n; i++) res += str;
                }
                i++;
                continue;
            }
            if (count == 0) res += s[i];
            i++;
        }

        return res;
    }
};