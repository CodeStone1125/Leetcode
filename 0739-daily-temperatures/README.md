<h2><a href="https://leetcode.com/problems/daily-temperatures/">739. Daily Temperatures</a></h2><h3>Medium</h3><hr><div><p>Given an array of integers <code>temperatures</code> represents the daily temperatures, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is the number of days you have to wait after the</em> <code>i<sup>th</sup></code> <em>day to get a warmer temperature</em>. If there is no future day for which this is possible, keep <code>answer[i] == 0</code> instead.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> temperatures = [73,74,75,71,69,72,76,73]
<strong>Output:</strong> [1,1,4,2,1,1,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,40,50,60]
<strong>Output:</strong> [1,1,1,0]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,60,90]
<strong>Output:</strong> [1,1,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
	<li><code>30 &lt;=&nbsp;temperatures[i] &lt;= 100</code></li>
</ul>
</div>

<h2>解法一: Stack</h2>
**Main idea**:利用Stack存還沒找到更高溫的日子，每次比較一個日子的溫度就把stack較低溫的日子，都pop並更新result array。

```
import java.util.Stack;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[ temperatures.length ];
        Stack<Integer> stack = new Stack<>(); //pair[value,index]
        int stackInd=0;
        for(int i=0;i<temperatures.length;i++){
            while((!stack.empty())&&(temperatures[stack.peek()]<temperatures[i])){
                stackInd=stack.pop();
                res[stackInd]=i-stackInd;
            }
            stack.push(i);
        }
        return res;
    }
}
```

所以可得下列分支結果
![image](https://github.com/Max-Chu1125/Leetcode/blob/main/0739-daily-temperatures/aHR0cHM6Ly9waWMubGVldGNvZGUtY24uY29tLzdhMTMzZTg1NzI3MWU2MzhjMDRiM2EyN2MxZWFiYzI5NTcwZTU4NWNjNDRkN2RhNjBlYjAzOTQ1OWE3Zjg5Y2QtNzM5LmdpZg.gif)




* **Time complexity：O(n)** 
* **Space complexity:O(n)**
