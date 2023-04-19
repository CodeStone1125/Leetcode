class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[mid] >= nums[l]){ //left sorted
                if((nums[l] > target)||(target>nums[mid])){ //絕對不在左邊
                    l = mid + 1;
                }
                else{
                    r=mid - 1;
                }        
            } 
            else{ //right sorted
                if((nums[mid] > target)||(target>nums[r])){ //絕對不在右邊
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }             
            } 
            
        }
        return -1;        
    }
}