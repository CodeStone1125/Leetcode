class Solution {
    public int maxArea(int[] height) {
        
        int v_max  = 0 ; int i = 0 ; int h_min = 0 ; int j = height.length - 1 ; 

        while ( j != i ){

            if ( height[i] < height[j]){
                h_min = height[i] ; 
            }else{
                h_min = height[j] ;
            }

            if (h_min*(j-i) > v_max){
                v_max = h_min*(j-i);
            }

            if (height[i] < height[j]){
                i++ ;
            }else{
                j-- ;
            }
        }
    return v_max ;
    }
}