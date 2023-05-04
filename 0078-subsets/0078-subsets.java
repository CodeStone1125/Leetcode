class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList<>();
        adder(ans, 0, nums, list);
        return ans;
    }
    public void adder(
        List<List<Integer>> ans
        , int start
        , int[] nums
        , List<Integer> list
    ){
        if(start>=nums.length){
            ans.add(new ArrayList<>(list));
        }else{
            //有該元素的
            list.add(nums[start]);
            adder(ans, start+1, nums, list);
            //沒該元素的
            list.remove(list.size()-1);
            adder(ans, start+1, nums, list);
        }
    }
}