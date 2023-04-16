class Solution {
    public int characterReplacement(String s, int k) {
        int Max=0;
        int l=0;
        int maxf=0;
        HashMap<Character, Integer> count = new HashMap<>();
        for(int r=0;r<s.length();r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf=Math.max(maxf,count.getOrDefault(s.charAt(r), 0));
            while(((r-l+1)-maxf)>k)
            {
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;     
                
            }
            Max=Math.max(r-l+1,Max);  
         }

         return Max;      
    }
}

