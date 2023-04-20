<h2><a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a></h2><h3>Medium</h3><hr><div><p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>sz</code>.</li>
	<li><code>1 &lt;= sz &lt;= 30</code></li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= sz</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do this in one pass?</p>
</div>

<h2>解法一: reverse 再刪 再reverse</h2>

簡單但是要多兩次reverse

<h2>解法二: two pointer</h2>

**Main idea**:
* 利用左右pointer同時往next移，兩pointer的距離用來控制倒數的距離。
* 這樣只要跑一次
* 注意不需要將要刪除的節點刪除，只需將前一個只到下一個(ie:以下圖為例，不用管3指到誰)
![](https://i.imgur.com/OgSkKdH.png)


```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = head;
        while(n>0){ //控制倒數的距離
            right = right.next;
            n--;
        }
        while(right!=null){
            right=right.next;
            left=left.next;
        }
        left.next=left.next.next;
        return dummy.next;
    }

}
```





* **Time complexity：O(n)** 
* **Space complexity:O(1)**

![](https://i.imgur.com/t4szUFs.png)

