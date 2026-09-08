class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res, num;
        for (String token : tokens) {
            switch(token){
                case "+":
                stack.push(stack.pop() + stack.pop());
                break;

                case "-":
                num = stack.pop();
                stack.push(stack.pop() - num);
                break;

                case "*":
                stack.push(stack.pop() * stack.pop());
                break;

                case "/":
                num = stack.pop();
                stack.push(stack.pop() / num);
                break;

                default:
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
