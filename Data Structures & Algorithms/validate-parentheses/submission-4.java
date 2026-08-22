class Solution {
    public boolean isValid(String s) {
        char ch;

        Stack<Character> stack = new Stack<>();
        for( int i=0; i<s.length(); i++ ) {
            ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                int top = stack.peek();

                if ((ch == ')' && top == '(') ||
                        (ch == '}' && top == '{') ||
                        (ch == ']' && top == '[')
                ) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
