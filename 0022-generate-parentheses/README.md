<h2><a href="https://leetcode.com/problems/generate-parentheses/">22. Generate Parentheses</a></h2><h3>Medium</h3><hr><div><p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> ["()"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>
</div>
<h2>解法一: Recursive</h2>
**Main idea**:觀察可得再加入 "(" or ")"時有三個規則
1. "("只要<n就可以任意加入
2. ")"數量小於"("才可加入
3. ")"和"("數量相同就是一解

```
class Solution {

    Stack<Character> stack = new Stack<>();  //全域
    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }
    private void backtrack(int openN, int closedN, int n) {
        if(openN ==closedN && closedN==n){ //Java利用將一組解加入list可能是較慢的原因之一
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n); //Recursive
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n); //Recursive
            stack.pop();
        }
    }
}
```

所以可得下列分支結果
![](https://i.imgur.com/XtmMFop.png)

* **Time complexity：![](https://i.imgur.com/BfEzVHg.png)**  //樹高
* **Space complexity:O(n)**

![](https://i.imgur.com/7zLCI2H.png)
