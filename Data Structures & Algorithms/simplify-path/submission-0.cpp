class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stac;
        string cur;
        stringstream ss(path);

        while (getline(ss, cur, '/')) {
            if (cur.empty()) continue;
            if (cur == "..") {
                if (!stac.empty()) stac.pop_back();
            } else if (!cur.empty() && cur != ".") {
                stac.push_back(cur);
            }
        }

        string res = "/";
        for (int i = 0; i < stac.size(); ++i) {
            if (i > 0) res += "/";
            res += stac[i];
        }
        
        return res;        
    }
};