class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string res = ""; 
        int m = min(word1.size(), word2.size());
        int n = max(word1.size(), word2.size());

        for (int i = 0; i < m; i++) {
            res += word1[i];
            res += word2[i];
        }

        if (word1.size() == n) res += word1.substr(m, n);
        if (word2.size() == n) res += word2.substr(m, n);

        return res;
    }
};