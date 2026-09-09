class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for (int i=0; i <= n; i++) {
            int num = i, j=0, count=0;
            while (num != 0) {
                int digit = num % 2;
                if (digit == 1) count++;
                num /= 2;
                j++;
            }
            res[i] = count;
        }
        return res;
    }
}
