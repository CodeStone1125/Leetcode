class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int current=0;
        int l=0; int r=1;

        while(r<prices.length){
            if(prices[l]<prices[r]){
                current=prices[r]-prices[l];
                profit=Math.max(current,profit);
            }
            else{
                l=r;
            }
            r++;
            

        }

        return profit;
        
    }
}