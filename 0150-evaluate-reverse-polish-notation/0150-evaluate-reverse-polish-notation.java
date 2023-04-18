class Solution {
    public int evalRPN(String[] tokens) {
        int op1,op2;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if(tokens[i].equals("-")){
                op2=stack.pop();
                op1=stack.pop();
                stack.push(op1-op2);
            }
            else if(tokens[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(tokens[i].equals("/")){
                op2=stack.pop();
                op1=stack.pop();
                stack.push(op1/op2);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}