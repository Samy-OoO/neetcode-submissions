class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        Set<Character> set = new HashSet<>();
        int[] target = new int[26];
        int[] s2Array = new int[26];
        int k = s1.length();

        for (char ch : s1.toCharArray()) {
            set.add(ch);
            s2Array[ch - 'a']++;
        }

        int l=0;
        for (int r=0; r<s2.length(); r++) {
            if (set.contains(s2.charAt(r))) s2Array[s2.charAt(r) - 'a']--;
            if (r-l+1 > k) {
                if (set.contains(s2.charAt(l))) s2Array[s2.charAt(l) - 'a']++;
                l++;
            }
            if (Arrays.equals(s2Array, target)) return true;
        }

        return false;  
    }
}
