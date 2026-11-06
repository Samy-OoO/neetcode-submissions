class Solution {
private:
    bool valid(string s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) return false;
            l++;
            r--;
        }
        return true;
    }

public:
    bool validPalindrome(string s) {
        int count = 0;
        int l = 0, r = s.size() - 1;
        
        while (l < r) {
            if (s[l] != s[r]) {
                if (valid(s, l+1, r) || valid(s, l, r-1)) return true;
                else return false;
            }            
            l++;
            r--;
        }

        return true;
    }
};