class Solution {
private:
    int sumOfSquares(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum += (rem * rem);
            n /= 10;
        }
        return sum;
    }

public:
    bool isHappy(int n) {
        unordered_set<int> hSet;
        while (!hSet.contains(n)) {
            hSet.insert(n);
            n = sumOfSquares(n);
            if (n == 1) return true;
        }
        return false;        
    }
};
