class Solution {
    public boolean isValid(String s) {
        char ch;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            ch = s.charAt(i);
            System.out.println(ch);
            try {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.pop() == '(') continue;
                    else return false;
                } else if (ch == '}') {
                    if (stack.pop() == '{') continue;
                    else return false;
                } else if (ch == ']') {
                    if (stack.pop() == '[') continue;
                    else return false;
                }
            } catch(EmptyStackException e){
                return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
