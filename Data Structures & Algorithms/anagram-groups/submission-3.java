public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String str: strs){
            str = str.toLowerCase();
            int[] counter = new int[26];
            for (char c: str.toCharArray()){
                counter[c - 'a']++;
            }

            String key = Arrays.toString(counter);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }
}