class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int size = n;

        while (size > 0) {
            int left = 0, right = size;
            while (right <= n) {
                int l = left, r = right-1;
                boolean isPalin = true;
                while(l <= r){
                    if (s.charAt(l) != s.charAt(r)) {
                        isPalin = false;
                        break;
                    }
                    l++;
                    r--;
                }
                if (isPalin) return s.substring(left, right);
                left++;
                right = left + size;
            }
            size--;
        }
        return "";
    }
}
