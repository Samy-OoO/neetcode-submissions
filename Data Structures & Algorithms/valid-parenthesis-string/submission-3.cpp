class Solution {
public:
    bool checkValidString(string s) {
        stack<int> stars;
        stack<int> stac;

        for (int i = 0; i < s.size(); i++) {
            switch(s[i]) {
                case '(':
                    stac.push(i);
                    break;
                case ')':
                    if (stac.empty() && stars.empty()) return false;
                    else if (!stac.empty()) stac.pop();
                    else stars.pop();
                    break;
                case '*':
                    stars.push(i);
                    break;
            }
        }
        
        if (stac.empty()) return true;

        while (!stac.empty() && !stars.empty()) {
            if (stac.top() < stars.top()) {
                stac.pop();
                stars.pop();
            } else return false;
        }

        return stac.empty();
    }
};
