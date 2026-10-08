class Solution {
    public int getSum(int a, int b) {
        int sum = 0;
        boolean carry = false;

        for (int i = 0; i < 32; i++) {
            int bitA = (a & (1 << i));
            int bitB = (b & (1 << i));

            if ( bitA != bitB ) {
                if (carry) carry = true;
                else {
                    sum = sum ^ (1 << i);
                    carry = false;
                }
            } 
            else {
                if (carry) sum = sum ^ (1 << i);

                if ( bitA == 0 ) carry = false;
                else carry = true;
            }
        }

        return sum;
    }
}
