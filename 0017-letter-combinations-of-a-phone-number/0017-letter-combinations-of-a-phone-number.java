import java.lang.String;
class Solution {
    String temp = "";
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList();
        if(digits.length()==0){
            return new ArrayList();
        }
        helper(digits, ans, 0, temp);
        return ans;
    }
    public void helper(String digits, List<String> ans, int start, String temp){
        String num[][] = {
            {"a","b","c"},
            {"d","e","f"},
            {"g","h","i"},
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r","s"},
            {"t","u","v"},
            {"w","x","y","z"}
        };
        if(start >= digits.length()){
            ans.add(new String(temp));
            return;
        }
        int x = Character.getNumericValue(digits.charAt(start));
        for(String s:num[x-2]){
            temp += s;
            helper(digits, ans, start+1, temp);
            temp = temp.substring(0, temp.length() - 1);;
        }
        return;
        
    }
}