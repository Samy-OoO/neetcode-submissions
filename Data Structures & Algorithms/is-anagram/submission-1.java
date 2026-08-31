class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i=0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            if (map1.containsKey(ch1)) map1.put(ch1, map1.get(ch1) + 1);
            else map1.put(ch1, 1);

            char ch2 = t.charAt(i);
            if (map2.containsKey(ch2)) map2.put(ch2, map2.get(ch2) + 1);
            else map2.put(ch2, 1);
        }
        
        return map1.equals(map2);
    }
}
