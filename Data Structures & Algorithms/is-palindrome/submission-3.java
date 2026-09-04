class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        s = s.toLowerCase();
        while(l < r) {
            while (l<r && !isAlphaNum(s.charAt(l))) l++;
            while (r>l && !isAlphaNum(s.charAt(r))) r--;
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphaNum(char c) {
        if (((int) 'a' <= (int) c && (int) c <= (int) 'z')
        || ((int) 'A' <= (int) c && (int) c <= (int) 'Z')
        || ((int) '0' <= (int) c && (int) c <= (int) '9')){
            return true;
        }

        return false;
    }
}
