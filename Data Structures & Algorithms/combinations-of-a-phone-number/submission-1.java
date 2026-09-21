class Solution {
    List<String> res = new ArrayList<>(); 
    String[] abc = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        
        backtrack(0, new StringBuilder(), digits);
        return res;
    }

    private void backtrack(int i, StringBuilder comb, String digits) {
        if (comb.length() == digits.length()) {
            res.add(comb.toString());
            return;
        }

        String letters = abc[digits.charAt(i) - '0'];
        for (char ch : letters.toCharArray()) {
            comb.append(ch);
            backtrack(i+1, comb, digits);
            comb.deleteCharAt(comb.length() - 1);
        } 
    }
}
