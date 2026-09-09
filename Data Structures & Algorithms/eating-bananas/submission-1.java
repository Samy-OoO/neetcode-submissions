class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int r = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int res = r;

        while (l <= r) {

            int k = l + (r-l)/2;
            long totalTime = 0;
            
            for (int p : piles) {
                totalTime += Math.ceil((double) p/k);
            }
            if (totalTime <= h){
                r = k - 1;
                res = k;
            } else l = k + 1;
        }

        return res;
    }
}
