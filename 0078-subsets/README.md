<h2><a href="https://leetcode.com/problems/subsets/">78. Subsets</a></h2><h3>Medium</h3><hr><div><p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible</em> <span data-keyword="subset"><em>subsets</em></span> <em>(the power set)</em>.</p>

<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [[],[0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li>
</ul>
</div>
<h2>解法一:Backtracing</h2>

**Main idea**:每個元素都需要call一次有他和沒他的
![](https://hackmd.io/_uploads/B1wRmfb4n.png)

```
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList<>();
        adder(ans, 0, nums, list);
        return ans;
    }
    public void adder(
        List<List<Integer>> ans
        , int start
        , int[] nums
        , List<Integer> list
    ){
        if(start>=nums.length){
            ans.add(new ArrayList<>(list));
        }else{
            //有該元素的
            list.add(nums[start]);
            adder(ans, start+1, nums, list);
            //沒該元素的
            list.remove(list.size()-1);
            adder(ans, start+1, nums, list);
        }
    }
}
```


* **Time complexity：O(nlogn)** 
* **Space complexity:O(n)**

![](https://hackmd.io/_uploads/BkAKLdC72.png)
