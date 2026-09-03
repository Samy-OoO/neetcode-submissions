class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res, num=0;

        for (String op : tokens) {
            switch (op) {
                case "+":
                res = stack.pop() + stack.pop();
                stack.push(res);
                break;
                case "-":
                num = stack.pop();
                res = stack.pop() - num;
                stack.push(res);
                break;
                case "*":
                res = stack.pop() * stack.pop();
                stack.push(res);
                break;
                case "/":
                num = stack.pop();
                res = stack.pop() / num;
                stack.push((int) res);
                break;
                default:
                stack.push(Integer.parseInt(op));
            }
        }
        return stack.pop();
    }
}
