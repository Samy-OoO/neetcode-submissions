class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int i = 0;
        int idx = -1;

        while (true) {
            int ch = strs[0][i];
            for (string str : strs) {
                if (i > str.size() || str[i] != ch) {
                    idx = i;
                    break;
                }
            }
            if (idx == i) break;
            i++;
        }

        return strs[0].substr(0, i);
    }
};