class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int l = 0;
        char ch;
        int longest = 0;

        for (int r = 0; r < n; r++) {
            ch = s.charAt(r);
            while (set.contains(ch)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            longest = Math.max(longest, r-l+1);
        }

        return longest;

    }
}
