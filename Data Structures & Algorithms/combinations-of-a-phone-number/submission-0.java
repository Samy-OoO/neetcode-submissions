class Solution {
    Map<Integer, String> dLMap = new HashMap<>();
    List<String> res = new ArrayList<>(); 

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        int j=0, inc;
        String abc = "abcdefghijklmnopqrstuvwxyz";
        for (int i=2; i<=9; i++) {
            if (i == 7 || i == 9) inc = 4;
            else inc = 3;
            String letters = abc.substring(j, j+inc);
            j += inc;
            dLMap.put(i, letters);
        }

        String[] strs = new String[digits.length()];
        for (int i=0; i<digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            String letters = dLMap.get(num);
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
