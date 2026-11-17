class Solution {
public:
    string addBinary(string a, string b) {
        string res = "";
        int carry = 0;
        int bound = max(a.size(), b.size());

        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());

        for (int i = 0; i < bound; i++) {
            int digA = i < a.size() ? a[i] - '0' : 0;
            int digB = i < b.size() ? b[i] - '0' : 0;

            int total = digA + digB + carry;
            string ch = to_string(total % 2);
            res = ch + res;
            carry = total / 2;
        }

        if (carry) res = "1" + res;

        return res;
    }
};