<style>

ol, ul {
	line-height: 2;
}

</style>

<h2><a href="https://leetcode.com/problems/longest-repeating-character-replacement/">424. Longest Repeating Character Replacement</a></h2><h3>Medium</h3><hr><div><p>You are given a string <code>s</code> and an integer <code>k</code>. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most <code>k</code> times.</p>

<p>Return <em>the length of the longest substring containing the same letter you can get after performing the above operations</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "ABAB", k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> Replace the two 'A's with two 'B's or vice versa.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "AABABBA", k = 1
<strong>Output:</strong> 4
<strong>Explanation:</strong> Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of only uppercase English letters.</li>
	<li><code>0 &lt;= k &lt;= s.length</code></li>
</ul>
</div>



<h2>解法一: Slice window</h2>

**Main idea**：

* 公式：window長度- window中出現最多的字元的次數 > k
* 所以Longest Repeating Character => 最長window長度可以滿足公式
* 有兩種得到window中出現最多的字元的次數
    1. 記下所有字母的出現次數然後取出最大值
    2. 額外變數維護最大值

1. **記下所有字母的出現次數然後取出最大值**

```
class Solution {
    public int characterReplacement(String s, int k) {
        int Max=0;
        int l=0;
        HashMap<Character, Integer> count = new HashMap<>();
        for(int r=0;r<s.length();r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            while(((r-l+1)-getMaxValue(count))>k)
            {
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;     
                
            }
            Max=Math.max(r-l+1,Max);  
         }

         return Max;      
    }
    
    public static <K, V extends Comparable<V>> V getMaxValue(Map<K, V> map)//掃過所有字母然後取出最大值 {
        V maxValue = null;
        for (V value : map.values()) {
            if (maxValue == null || value.compareTo(maxValue) > 0) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}

```
![](https://i.imgur.com/UpG4cjt.png)

* **Time complexity：O(26n)**  //26個字母
* **Space complexity:O(n)**

![](https://i.imgur.com/6KXCpGR.png)

2. **額外變數維護最大值**
```
class Solution {
    public int characterReplacement(String s, int k) {
        int Max=0;
        int l=0;
        int maxf=0;
        HashMap<Character, Integer> count = new HashMap<>();
        for(int r=0;r<s.length();r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf=Math.max(maxf,count.getOrDefault(s.charAt(r), 0));//存最大值並比較
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
```

主要討論如何維護window中次數最大值(maxf)：

* maxf只有可能在右邊指標右移的時候，移到的字母:(假設最多的字母是A)

    * A:則maxf+1
    * others:maxf不變

* <font color="#f00">重點: maxf在左邊指標右移時，不需要減少maxf</font>

    證明: 

1. 公式：window長度- window中出現最多的字元的次數
2. maxf左移時window長度必定減少，既使滿足條件了，則現在window長度絕對不會大於現有的最大滿足window長度。
3. 所以在左邊指標右移maxf不會影響最大滿足window長度
```
while(((r-l+1)-maxf)>k) //公式不滿足
{
    count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1); //要維護字元數量
    l++;//但是不用維護maxf
}
```
    
4. 因此在maxf在左邊指標右移時，不需要減少maxf
5. 直到再次右邊指標再次右移時，直接取出count即可(同理指標右移)

```
maxf= Math.max(maxf,count.getOrDefault(s.charAt(r), 0)); //存最大值並比較
```

![](https://i.imgur.com/I5HRfNG.png)

* **Time complexity：O(n)**
* **Space complexity:O(1)**



