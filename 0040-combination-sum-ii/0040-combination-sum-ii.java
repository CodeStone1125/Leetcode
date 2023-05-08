class Solution {
    List<Integer> list = new ArrayList();
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        else{
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                helper(candidates, total + candidates[i], target, i + 1);
                list.remove(list.get(list.size() - 1));
            }
            
        }
         

    }
}