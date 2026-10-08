class Solution {
    public int reverse(int x) {
        int res = 0;
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        
        while (x != 0) {
            if (res > MAX/10 || res < MIN/10) return 0;

            int r = x % 10;
            if ((res == MAX/10 && r > MAX % 10) || 
                (res == MIN/10 && r < MIN % 10)) return 0;

            res = res*10 + r;
            x /= 10;
        }

        return res;
    }
}
