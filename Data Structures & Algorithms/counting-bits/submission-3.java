class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for (int i=1; i < n+1; i++) {
            int count = 0;
            for (int j=0; j < 32; j++) {
                if ((i & (1 << j)) != 0) count++;
            }
            res[i] = count;
        }

        return res;
    }
}
