class Solution {
    public int hammingWeight(int n) {
        int res=0, i=0;
        while (n != 0) {
            int digit = n % 2;
            if (digit == 1) res++;
            n /= 2;
            i++;
        }
        return res;
    }
}
