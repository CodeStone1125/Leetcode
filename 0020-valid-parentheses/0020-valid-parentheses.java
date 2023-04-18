import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        int temp=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            System.out.println(s.charAt(i));
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
                System.out.printf("推%c\n",s.charAt(i));
            }
            else if(s.charAt(i)==')'){   
                if(stack.empty()){
                    return false;
                }
                if(stack.pop()!='('){

                    return false;
                }
            }
            else if(s.charAt(i)=='}'){   
                if(stack.empty()){
                    return false;
                }
                if(stack.pop()!='{'){

                    return false;
                }
            }
            else if(s.charAt(i)==']'){   
                if(stack.empty()){
                    return false;
                }
                if(stack.pop()!='['){

                    return false;
                }
            }
        }           
        System.out.println(stack.empty());
        return stack.empty();
    }
        
}
