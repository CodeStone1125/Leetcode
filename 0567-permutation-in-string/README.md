<h2><a href="https://leetcode.com/problems/permutation-in-string/">567. Permutation in String</a></h2><h3>Medium</h3><hr><div><p>Given two strings <code>s1</code> and <code>s2</code>, return <code>true</code><em> if </em><code>s2</code><em> contains a permutation of </em><code>s1</code><em>, or </em><code>false</code><em> otherwise</em>.</p>

<p>In other words, return <code>true</code> if one of <code>s1</code>'s permutations is the substring of <code>s2</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s1 = "ab", s2 = "eidbaooo"
<strong>Output:</strong> true
<strong>Explanation:</strong> s2 contains one permutation of s1 ("ba").
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s1 = "ab", s2 = "eidboaoo"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li>
</ul>
</div>

<h2>解法一: Slice window</h2>

<font color="#f00">Note:</font> Slicewindow和Two pointer的差別是前者對Window內**所有的元素**做操作，但是後者只關心**兩個Point所指**的值。



**Main idea:**

**1. 以s1作為長度作為window尺寸**

**2. 確認s1的permutation是否為s2的string(比較兩者字母數量是否相同)**



根據比較字母數量的方式分為兩種
* **直接26個字母比較**
* **額外變數**

1. **直接26個字母比較**
```
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
            if(score==26) //如果26個字母都相同
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

```
利用array存取字元次數，每次需確認所有的字元是否個數一樣。
```
for (int i=0;i<26;i++) { //確認是substring的permutation
                if(count1[i]==count2[i]){ //確認所有字母出現次數
                    score+=1;   //相同則加分
                    
                }
                else{ //有字母次數不同
                    break;
                }
                
            }
```
* **Time complexity：O(26n)**
* **Space complexity:O(n)**
![](https://i.imgur.com/SZnJA25.png)


2. **額外變數**

重點:利用額外變數紀錄<font color="#f00">目前個數一樣的字母次數</font>，所以window移動時只要確認右左標及左指標的字幕是否match即可
```
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
        for (int i=0;i<26;i++) { //只需計算一次總共有多少字母相同
                if(count1[i]==count2[i]){
                    match+=1;  
                    
                }
        }

        for(int r=s1.length();r<s2.length();r++){
            if(match==26){ //如果找到
                return true;
            }

            index=s2.charAt(r)-'a'; //右指標維護
            count2[index]+=1;
            if(count2[index]==count1[index]){
                match+=1;
            }
            else if(count2[index]==count1[index]+1){
                match-=1;
            }
            index=s2.charAt(l)-'a'; //左指標維護
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
```

* **Time complexity：O(n)**
* **Space complexity:O(n)**

![](https://i.imgur.com/AMg0aNR.png)

