class Solution {
    List<Integer> list = new ArrayList();
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0);
        return ans;
    }
    public void helper(
        int[] candidates   
        , int target
        , int start
    ){

        System.out.println(list);
        if(target == 0){
            ans.add(new ArrayList<>(list));
            System.out.println(ans);
            return;
        }
        if(start > candidates.length - 1|| 0 > target){
            return;
        }        
        
        list.add(candidates[start]);
        helper(candidates, target-candidates[start], start);
        list.remove(list.size()-1);
        helper(candidates, target, start + 1);
        
    }
}