class Solution {
    public int trap(int[] height) {
        
        int count = 0;
        if (height == null || height.length == 0) return count;
        
        
        int l = 0; int r = height.length-1;
        int leftMax=height[l];
        int rightMax=height[r];
            
        while(l<r){
            if(leftMax<rightMax){
                l+=1;
                leftMax = Math.max(leftMax,height[l]);
                count += (leftMax-height[l]);
            }

            else{
                    r-=1;
                    rightMax = Math.max(rightMax,height[r]);
                    count += (rightMax-height[r]);
                
            }
        }  
        
        return count;
    }
}