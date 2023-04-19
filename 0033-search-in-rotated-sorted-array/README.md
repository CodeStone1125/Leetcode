<h2><a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">33. Search in Rotated Sorted Array</a></h2><h3>Medium</h3><hr><div><p>There is an integer array <code>nums</code> sorted in ascending order (with <strong>distinct</strong> values).</p>

<p>Prior to being passed to your function, <code>nums</code> is <strong>possibly rotated</strong> at an unknown pivot index <code>k</code> (<code>1 &lt;= k &lt; nums.length</code>) such that the resulting array is <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code> (<strong>0-indexed</strong>). For example, <code>[0,1,2,4,5,6,7]</code> might be rotated at pivot index <code>3</code> and become <code>[4,5,6,7,0,1,2]</code>.</p>

<p>Given the array <code>nums</code> <strong>after</strong> the possible rotation and an integer <code>target</code>, return <em>the index of </em><code>target</code><em> if it is in </em><code>nums</code><em>, or </em><code>-1</code><em> if it is not in </em><code>nums</code>.</p>

<p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2], target = 0
<strong>Output:</strong> 4
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2], target = 3
<strong>Output:</strong> -1
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1], target = 0
<strong>Output:</strong> -1
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li>All values of <code>nums</code> are <strong>unique</strong>.</li>
	<li><code>nums</code> is an ascending array that is possibly rotated.</li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>
</div>
<h2>解法一: Binary Search</h2>

**Main idea**:rotated的依然有一半是完全sorted(觀察可得)
1. 判斷mid是屬於左邊sorted part還右邊 sort part
2. 只有sorted的部分可以確認排除
3. 以下圖為例target>mid或是target<left就可以確認排除左邊

![](https://i.imgur.com/m2dTpfZ.png)

```
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[mid] >= nums[l]){ //left sorted
                if((nums[l] > target)||(target>nums[mid])){ //絕對不在左邊
                    l = mid + 1;
                }
                else{
                    r=mid - 1;
                }        
            } 
            else{ //right sorted
                if((nums[mid] > target)||(target>nums[r])){ //絕對不在右邊
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }             
            } 
            
        }
        return -1;        
    }
}
```





* **Time complexity：O(logn)** 
* **Space complexity:O(1)**

![](https://i.imgur.com/cizry3P.png)
