class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        s = s.toLowerCase();
        t = t.toLowerCase();

        int[] array = new int[26];

        for (int j=0; j<s.length(); j++) {
            array[s.charAt(j) - 'a']++;
            array[t.charAt(j) - 'a']--;
        }

        for (int k : array){
            if (k != 0) return false;
        }
        return true;
    }
}
