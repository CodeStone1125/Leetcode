<h2><a href="https://leetcode.com/problems/car-fleet/">853. Car Fleet</a></h2><h3>Medium</h3><hr><div><p>There are <code>n</code> cars going to the same destination along a one-lane road. The destination is <code>target</code> miles away.</p>

<p>You are given two integer array <code>position</code> and <code>speed</code>, both of length <code>n</code>, where <code>position[i]</code> is the position of the <code>i<sup>th</sup></code> car and <code>speed[i]</code> is the speed of the <code>i<sup>th</sup></code> car (in miles per hour).</p>

<p>A car can never pass another car ahead of it, but it can catch up to it&nbsp;and drive bumper to bumper <strong>at the same speed</strong>. The faster car will <strong>slow down</strong> to match the slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).</p>

<p>A <strong>car fleet</strong> is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.</p>

<p>If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.</p>

<p>Return <em>the <strong>number of car fleets</strong> that will arrive at the destination</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
Note that no other cars meet these fleets before the destination, so the answer is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> target = 10, position = [3], speed = [3]
<strong>Output:</strong> 1
<strong>Explanation:</strong> There is only one car, hence there is only one fleet.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> target = 100, position = [0,2,4], speed = [4,2,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The fleet moves at speed 2.
Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == position.length == speed.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt; target &lt;= 10<sup>6</sup></code></li>
	<li><code>0 &lt;= position[i] &lt; target</code></li>
	<li>All the values of <code>position</code> are <strong>unique</strong>.</li>
	<li><code>0 &lt; speed[i] &lt;= 10<sup>6</sup></code></li>
</ul>
</div>

<h2>解法一: Stack</h2>

**Main idea:其實就是x軸為時間Y軸為初始位置，speed為斜率。計算交集的邏輯問題。**

1. 比較方式:計算每台車的位置到終點的時間=(target-position)/speed。
2. 因為無法超車，所以只要你的前面有車很慢，不管你多快都會被擋下來。
3. 所以要從離終點最近的車子開始比較，因為更前面的車子都會受到影響。

```
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < position.length; i++) { //為了將車輛按照位置排序
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, java.util.Comparator.comparingInt(o -> o[0]));
        for(int i=combine.length-1;i>=0;i--){
            double currentTime= (double) (target-combine[i][0])/combine[i][1]; //幾秒到終點
            if(!stack.empty()&& (stack.peek() >= currentTime)){ 
                continue;
            }
            else{
                stack.push(currentTime);//不同fleet
            }

        }
        return stack.size();
    }
}
```
* stack頂部的記錄的是在你前面車子到達終點的時間。
* 如果你的時間比對方長代表你不會被擋到，所以不會加入同一fleet。
* 因此把你放入stack因為你成為那個可能擋到別車的車。
```
if(!stack.empty()&& (stack.peek() >= currentTime)){ 
    continue;
}
else{
    stack.push(currentTime);//不同fleet
}

```

* **Time complexity：O(nlogn)** 
* **Space complexity:O(n)**

![](https://i.imgur.com/TUASvWJ.png)

