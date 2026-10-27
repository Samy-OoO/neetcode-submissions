class Solution {
public:
    vector<int> partitionLabels(string s) {
        unordered_map<char, int> last0cc;
        vector<int> res;

        for (int i = 0; i < s.size(); i++) {
            last0cc[s[i]] = i;
        }

        int l = 0, r = 0;
        while (r < s.size()) {
            int last = last0cc[s[r]];
            while (r < last) {
                r++;
                last = max(last, last0cc[s[r]]);
            }
            res.push_back(r-l+1);
            l = r + 1;
            r = l;
        }

        return res;        
    }
};
