<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a></h2><h3>Easy</h3><hr><div><p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>
</div>
<h2>解法一: Two pointer</h2>


```
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int current=0;
        int l=0; int r=1;

        while(r<prices.length){  //右價大於左價
            if(prices[l]<prices[r]){
                current=prices[r]-prices[l];
                profit=Math.max(current,profit);
            }
            else if(prices[l]==prices[r]){//左右同價格
                
            }
            else{  //右價小於左價
                l=r;
            }
            r++;
            

        }

        return profit;
        
    }
}
```
**Main idea: 左買右賣**

比較左右pointer價格會遇到以下三種情況:
* **左>右**
* **左=右**
* **左<右**

1. **左<右**
當右邊的價格比左邊大的時候，代表也許左邊是最低價格，所以計算利潤如果比現有最大利潤大則更新利潤。
```
if(prices[l]<prices[r]){
    current=prices[r]-prices[l];
    profit=Math.max(current,profit);
}
```
2. **左=右** 
左右同價格時，則沒有比較的必要。
```
else if(prices[l]==prices[r]){
                
}
```
3. **左>右**
另一方面當右價小於左價時代表現在右邊指的才有可能是最低價，因此左pointer直接指到右價位置。
```
else{  //右價小於左價
    l=r;
 }
```
最後不論何種情況，右指針都會向下一個尋找直到最後一個價格。
* **Time complexity：O(n)**
* **Space complexity:O(1)**
