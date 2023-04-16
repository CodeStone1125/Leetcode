class Solution {
    public int lengthOfLongestSubstring(String s) {
        int Max=0;
        Set<Character> set = new HashSet<>();
        int l=0;
        if(s.length()==0||s.length()==1){
            return s.length();
        }

       for(int r=0;r<s.length();r++){ 
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
                Max=Math.max(r-l+1,Max);
                System.out.printf("%s,%s\n",s.charAt(l),s.charAt(r));
                System.out.printf("Max,current:%d,%d\n",Max,r-l+1);
            }
            set.add(s.charAt(r));
            Max=Math.max(r-l+1,Max);
            System.out.printf("%s,%s\n",s.charAt(l),s.charAt(r));
            System.out.printf("Max,current:%d,%d\n",Max,r-l+1);
            
            
            

        }

        return Max;
    }
}