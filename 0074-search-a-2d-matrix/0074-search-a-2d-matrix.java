class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        if(matrix.length!=1){
            while((matrix[l][matrix[l].length-1]<=target) && ((l+1)<=(matrix.length-1))){
                System.out.printf("%d",l);
                if(matrix[l][matrix[l].length-1]==target){
                    return true;
                }
                l++;
                System.out.println(l);
            }
        }
        return search(matrix[l],target)!=-1;
        
    }
    
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
        }
        return -1;
        
    }
}