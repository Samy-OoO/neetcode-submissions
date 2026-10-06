class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character, Integer> map = new HashMap<>();

        int k = 1;
        for (char letter : order.toCharArray()) {
            map.put(letter, k++);
        }

        for (int i=0; i < words.length-1; i++) {
            String cur = words[i], next = words[i+1];

            for (int j=0; j < cur.length(); j++) {
                if (j == next.length()) return false;

                if (cur.charAt(j) != next.charAt(j)){
                    if (map.get(cur.charAt(j)) > map.get(next.charAt(j))) return false;
                    break;
                }
            }
        }

        return true;
    }
}