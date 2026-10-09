class Solution {
    List<String> res = new ArrayList<>();
    Map<Integer, String> numMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;

        String[] abc = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 2; i <= 9; i++) {
            numMap.put(i, abc[i-2]);
        }

        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String str, String digits) {
        if (str.length() == digits.length()) {
            res.add(str);
            return;
        }

        int digit = digits.charAt(i) - '0';
        for (char ch : numMap.get(digit).toCharArray()) {
            backtrack(i+1, str + ch, digits);
        }
    }
}
