class Solution {
    public int evalRPN(String[] tokens) {
        int op1,op2;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(Character.isDigit(tokens[i].charAt(tokens[i].length()-1))){
                stack.push(Integer.parseInt(tokens[i]));
                System.out.println("push");
            }
            else if(tokens[i].equals("+")){
                op2=stack.pop();
                op1=stack.pop();
                stack.push(op1+op2);
                System.out.printf("%d+%d\n",op1,op2);
            }
            else if(tokens[i].equals("-")){
                op2=stack.pop();
                op1=stack.pop();
                stack.push(op1-op2);
                System.out.printf("%d-%d\n",op1,op2);
            }
            else if(tokens[i].equals("*")){
                op2=stack.pop();
                op1=stack.pop();
                stack.push(op1*op2);
                System.out.printf("%d*%d\n",op1,op2);
            }
            else if(tokens[i].equals("/")){
                op2=stack.pop();
                op1=stack.pop();
                stack.push(op1/op2);
                System.out.printf("%d/%d\n",op1,op2);
            }
        }
        return stack.pop();
    }
}