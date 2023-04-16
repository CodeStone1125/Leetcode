<h2><a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a></h2><h3>Medium</h3><hr><div><p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty"><strong>substring</strong></span> without repeating characters.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abcabcbb"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "abc", with the length of 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "bbbbb"
<strong>Output:</strong> 1
<strong>Explanation:</strong> The answer is "b", with the length of 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "pwwkew"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
</ul>
</div>
<h2>解法一: 暴力法</h2>


**Main idea: 計算出所有substring的長度**
* **Time complexity：O(n^2)**
* **Space complexity:O(1)**



<h2>解法二: Slice window</h2>

<font color="#f00">Note:</font> Slicewindow和Two pointer的差別是前者對Window內**所有的元素**做操作，但是後者只關心**兩個Point所指**的值。

```
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

            }
            set.add(s.charAt(r));
            Max=Math.max(r-l+1,Max);
            

        }

        return Max;
    }
}
```
**Main idea: 只要裡面有重複的字元，就絕對不符合，所以右邊加入重複字元時，左邊就要向右直到沒有重複的字元**

每次右邊加入一個字元會遇到兩種情況:
* **含有相同字元**
* **不含**

1. **含有相同字元**
利用Hashset判斷是否有相同字元，如果有則將左邊就要向右直到沒有重複的字元。並計算長度，更新最大值。
```
while(set.contains(s.charAt(r))){
    set.remove(s.charAt(l));
    l++;
    Max=Math.max(r-l+1,Max);

}
```

2. **不含**
直接計算長度，更新最大值。
```
set.add(s.charAt(r));
Max=Math.max(r-l+1,Max);
```
* **Time complexity：O(n)**
* **Space complexity:O(1)**

![](https://i.imgur.com/MMxaPcZ.png)

