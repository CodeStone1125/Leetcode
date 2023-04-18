import java.util.Stack;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[ temperatures.length ];
        Stack<Integer> stack = new Stack<>(); //pair[value,index]
        int stackInd=0;
        for(int i=0;i<temperatures.length;i++){
            // System.out.printf("今天溫度%d\n",temperatures[i]);
            while((!stack.empty())&&(temperatures[stack.peek()]<temperatures[i])){
                stackInd=stack.pop();
                res[stackInd]=i-stackInd;
                // System.out.printf("%d到%d有%d天\n",stackInd,i,i-stackInd);
            }
            stack.push(i);
            // System.out.printf("push:%d\n",temperatures[i]); 
        }
        return res;
    }
}