class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderIdx = new HashMap<>();

        for (int i=0; i < order.length(); i++) {
            orderIdx.put(order.charAt(i), i);
        }

        for (int i=0; i < words.length-1; i++) {
            String w1 = words[i], w2 = words[i+1];

            for (int j=0; j < w1.length(); j++) {
                if (j == w2.length()) return false;

                if (w1.charAt(j) != w2.charAt(j)) {
                    if (orderIdx.get(w2.charAt(j)) < orderIdx.get(w1.charAt(j))) return false;
                    break;
                }
            }
        }

        return true;
    }
}