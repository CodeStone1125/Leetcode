class Solution {
    HashMap<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
            int count = map.getOrDefault(list,0);
            if(count==0){
                ans.add(new ArrayList<>(list));
                map.put(list,count+1);
            }
            
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
