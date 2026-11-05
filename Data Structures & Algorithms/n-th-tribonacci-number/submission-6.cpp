class Solution {
private:
    vector<int> memo;

    int tri(int n) {
        if (memo[n] != -1) return memo[n];
        if (n == 1 || n == 2) return memo[n] = 1;
        return memo[n] = tri(n-1) + tri(n-2) + tri(n-3);
    }

public:
    int tribonacci(int n) {
        memo = vector<int>(n+1, -1);
        memo[0] = 0;
        return tri(n);
    }
};