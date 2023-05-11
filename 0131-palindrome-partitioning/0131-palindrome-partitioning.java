class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        if(s.equals("")||s.length()==0){
            return new ArrayList();
        }
        helper(s, ans, new ArrayList());
        return ans;
    }
    public void helper(String s, List<List<String>> ans, List<String> list) {
        if(s.equals("")||s.length()==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String temp = s.substring(0, i);
            if(isPalindrome(temp)){
                list.add(temp);
                helper(s.substring(i, s.length()), ans, list);
                list.remove(list.size() - 1);
            }
        }
        return;
        
    }
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}