class Solution {
    public int[] twoSum(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length-1;
        int[] ans = new int[2];
        
        while(p1 < p2){
            int sum = nums[p1]+nums[p2];     
            if(sum == target){
                ans[0] = p1+1;
                ans[1] = p2+1;
                break;
            }
            else if(sum > target){
                p2--;
            }
            else{
                p1++;
            }
        }
        return ans;
    }
}