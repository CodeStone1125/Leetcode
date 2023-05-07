class Solution {
    List<Integer> list = new ArrayList();
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, 0, target, 0);
        return ans;
    }
    private void helper(
        int[] candidates   
        , int total
        , int target
        , int start
        
    ){
        if(target == total){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(start > candidates.length - 1|| total > target){
            return;
        }        
        
        list.add(candidates[start]);
        helper(candidates, total+candidates[start], target, start);
        list.remove(list.size()-1);
        helper(candidates, total, target, start + 1);
            
        
        
    }
}