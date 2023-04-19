class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int Max = piles[0];
        int sum=0;
        for(int i=0;i<piles.length;i++){
                Max=Math.max(piles[i],Max); 
        }
        int mid=0;
        while(min<Max){
            sum=0;
            mid=(min+Max)/2;
            for(int i=0;i<piles.length;i++){
                sum+=Math.ceil((double)piles[i]/mid);      
            }
    
            if(sum<=h){ //mid太大
                Max=mid;      
            }
            else if(sum>h){ //mid太小
                min=mid+1;
            }
        }
        return Max;
    }
}