class Solution {
    public int reverseBits(int n) {
        int res = 0, curBit;
        for (int i=0; i < 32; i++) {
            curBit = (n & (1 << i)) == 0 ? 0 : 1;
            res = res | (curBit << (31 - i));
        }

        return res;
    }
}
