class Solution {
    public boolean isPalindrome(String s) {

        int l=0, r=s.length()-1;
        char chL, chR;
        String s_Lower = s.toLowerCase();
        while(l<r){
            while (l<r && !alphaNum(s_Lower.charAt(l))) l+=1;
            while (r>l && !alphaNum(s_Lower.charAt(r))) r-=1;
            if (s_Lower.charAt(l) != s_Lower.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    public boolean alphaNum(char c){
        int ch = (int) c;
        return (((int)'A' <= ch && ch <= (int)'Z') ||
                ((int)'a' <= ch && ch <= (int)'z') ||
                ((int)'0' <= ch && ch <= (int)'9'));

    }
}
