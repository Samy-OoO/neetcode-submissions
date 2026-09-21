class Solution {
    List<String> res = new ArrayList<>(); 

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        int j=0, inc;
        String[] abc = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        String[] strs = new String[digits.length()];
        for (int i=0; i<digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            String letters = abc[num];
            strs[i] = letters;
        }
        
        backtrack(0, new StringBuilder(), strs);
        return res;

    }

    private void backtrack(int i, StringBuilder comb, String[] strs) {
        if (comb.length() == strs.length) {
            res.add(comb.toString());
            return;
        }
        if (i >= strs.length) return;

        for (int j=0; j<strs[i].length(); j++) {
            comb.append(strs[i].substring(j, j+1));
            backtrack(i+1, comb, strs);
            comb.deleteCharAt(comb.length() - 1);
        }        
    }
}
