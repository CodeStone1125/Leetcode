class Solution {
    public boolean checkInclusion(String s1, String s2) {
        System.out.printf("s1=%d,s2=%d\n",s1.length(),s2.length());
        int l=0;
        int match=0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int index=0;
        if(s1.length()>s2.length()){
            return false;
        }
        
        for(int i=0;i<s1.length();i++){
            count1[s1.charAt(i)-'a']+=1;
            count2[s2.charAt(i)-'a']+=1;
        }
        for (int i=0;i<26;i++) { //確認是substring的permutation
                if(count1[i]==count2[i]){ //確認所有字母出現次數
                    match+=1;   //相同則加分
                    
                }
        }

        for(int r=s1.length();r<s2.length();r++){
            if(match==26){ //如果找到
                return true;
            }
            System.out.println(match);
            index=s2.charAt(r)-'a'; //右指標
            count2[index]+=1;
            if(count2[index]==count1[index]){
                match+=1;
            }
            else if(count2[index]==count1[index]+1){
                match-=1;
            }
            index=s2.charAt(l)-'a'; //左指標
            count2[index]-=1;
            if(count2[index]==count1[index]){
                match+=1;
            }
            else if(count2[index]==count1[index]-1){
                match-=1;
            }
            l++;
        }
        if(match==26){ //如果找到
                return true;
        }
        return false;
    }
}
