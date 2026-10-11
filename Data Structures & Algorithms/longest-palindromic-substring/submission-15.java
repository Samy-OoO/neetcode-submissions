class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;
        
        int idx = 0, len = 0;

        // Odd-length Palindromes
        for (int i=0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > len) {
                    idx = l;
                    len = r - l + 1;
                }
                l--;
                r++;
            }
        
        
            l = i;
            r = i+1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > len) {
                    idx = l;
                    len = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return s.substring(idx, idx + len);
    }
}
