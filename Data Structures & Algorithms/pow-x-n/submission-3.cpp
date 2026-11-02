class Solution {
private:
    double findPow(double x, long long n) {
        if (n <= 0) return 1;
        if (n == 1) return x;
        
        double half = findPow(x, n / 2);    

        if (n % 2 == 0) return half * half;
        return half * half * x;
    }

public:
    double myPow(double x, int n) {
        long long power = n;
        if (power < 0) {
            x = 1/x;
            power = -power;
        }
        return findPow(x, power);
    }
};
