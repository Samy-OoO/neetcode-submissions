class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();
        digits[n-1] += carry (digits, 1, n);

        if (digits[0] == 0) digits.insert(digits.begin(), 1);
        return digits;
    }

    int carry(vector<int>& digits, int i, int n) {
        if (digits[n-i] != 9) return 1; 

        digits[n-i] = 0;
        if (n-i-1 >= 0) digits[n-i-1] += carry(digits, i+1, n);
        return (-1 * digits[n-i]);
    }
};
