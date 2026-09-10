class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        
        // O(log(min(m, n)))
        int l = 0, r = A.length;
        int i, j;

        while (true) {
            i = (l + r) / 2; // A
            j = half - i; // B

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                // Odd
                if (total % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }
                // Even
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } 
            else if (Aleft > Bright){
                r = i - 1;                
            }
            else {
                l = i + 1;
            }
        }
    }
}
