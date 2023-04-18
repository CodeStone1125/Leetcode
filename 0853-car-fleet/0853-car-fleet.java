class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < position.length; i++) { //為了將車輛按照位置排序
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, java.util.Comparator.comparingInt(o -> o[0]));
            for(int i=combine.length-1;i>=0;i--){
                double currentTime= (double) (target-combine[i][0])/combine[i][1]; //幾秒到終點
                if(!stack.empty()&& (stack.peek() >= currentTime)){
                    continue;
                }
                else{
                    stack.push(currentTime);//不同fleet
                }
                    
            }
        return stack.size();
    }
}