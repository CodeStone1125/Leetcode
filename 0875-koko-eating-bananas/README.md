<h2><a href="https://leetcode.com/problems/koko-eating-bananas/">875. Koko Eating Bananas</a></h2><h3>Medium</h3><hr><div><p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div>

<h2>解法一: 暴力解</h2>

**Main idea:帶入k=1~最大值。**
* **Time complexity：O(n*length(piles))** 
* **Space complexity:O(1)**


<h2>解法二: Binary Search</h2>

```
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int Max = piles[0];
        int sum=0;
        for(int i=0;i<piles.length;i++){ //找到最大值
                Max=Math.max(piles[i],Max); 
        }
        int mid=0;
        while(min<Max){
            sum=0;
            mid=(min+Max)/2;
            for(int i=0;i<piles.length;i++){
                sum+=Math.ceil((double)piles[i]/mid); 
            }

            if(sum<=h){ //mid太大
                Max=mid;      
            }
            else if(sum>h){ //mid太小
                min=mid+1;
            }
        }
        return Max;
    }
}
```
* 要返回Double 取上限才有用
```
for(int i=0;i<piles.length;i++){
    sum+=Math.ceil((double)piles[i]/mid); 
}
```
* 因為這邊只要可以小於hours所以條件取(sum<=h)且MAX=mid(而不是和binary search一樣取MAX=mid+1)

```
if(sum<=h){ //mid太大
    Max=mid;      
}
```

* **Time complexity：O(logn*length(piles))** 
* **Space complexity:O(1)**

![](https://i.imgur.com/qT50Fbt.png)


