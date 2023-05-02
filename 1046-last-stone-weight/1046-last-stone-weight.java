class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1){
            return   stones[0]; 
        }
        PriorityQueue<Integer> pq =new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        int max1 = 0;
        int max2 = 0;
        while(pq.size()>1){
            max1 = pq.poll();
            max2 = pq.poll();
            
            if(Math.abs(max1-max2)!=0){
                pq.add(Math.abs(max1-max2));
            }
        }
        if(pq.peek()==null){
            return 0;
        }
        return pq.peek();
        
    }
}