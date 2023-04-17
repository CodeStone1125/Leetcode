class Solution {
    public boolean checkInclusion(String s1, String s2) {
        System.out.printf("s1=%d,s2=%d\n",s1.length(),s2.length());
        int l=0;
        int r=s1.length()-1;
        int score=0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        if(s1.length()>s2.length()){
            return false;
        }
        
        for(int i=0;i<s1.length();i++){
            count1[s1.charAt(i)-'a']+=1;
            count2[s2.charAt(i)-'a']+=1;
        }
        
        // 找遍map
        while(r<s2.length()){
            score=0;
            for (int i=0;i<26;i++) { //確認是substring的permutation
                if(count1[i]==count2[i]){ //確認所有字母出現次數
                    score+=1;   //相同則加分
                    
                }
                else{ //有字母次數不同
                    break;
                }
                
            }
            System.out.printf("l=%d,r=%d\n",l,r);
            if(score==26) //如果找到
            {
                return true;
            }
            if(r==(s2.length()-1)){ //window到底了
                break;
            }
            count2[s2.charAt(l)-'a']-=1;//window整個右移
            r++;
            l++;
            count2[s2.charAt(r)-'a']+=1;
            
        }
        return false;
    }
}
