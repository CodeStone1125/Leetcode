<h2><a href="https://leetcode.com/problems/subtree-of-another-tree/">572. Subtree of Another Tree</a></h2><h3>Easy</h3><hr><div><p>Given the roots of two binary trees <code>root</code> and <code>subRoot</code>, return <code>true</code> if there is a subtree of <code>root</code> with the same structure and node values of<code> subRoot</code> and <code>false</code> otherwise.</p>

<p>A subtree of a binary tree <code>tree</code> is a tree that consists of a node in <code>tree</code> and all of this node's descendants. The tree <code>tree</code> could also be considered as a subtree of itself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/28/subtree1-tree.jpg" style="width: 532px; height: 400px;">
<pre><strong>Input:</strong> root = [3,4,5,1,2], subRoot = [4,1,2]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/28/subtree2-tree.jpg" style="width: 502px; height: 458px;">
<pre><strong>Input:</strong> root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the <code>root</code> tree is in the range <code>[1, 2000]</code>.</li>
	<li>The number of nodes in the <code>subRoot</code> tree is in the range <code>[1, 1000]</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= root.val &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= subRoot.val &lt;= 10<sup>4</sup></code></li>
</ul>
</div>

<h2>解法一:暴力法</h2>

**Main idea**:
1. taverse所有node只要和subtree root 值一樣
2. 找到就檢查是否是相同樹
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        traverse(root,subRoot);
        return ans;
        
    }
    public void traverse(TreeNode root ,TreeNode subRoot ) {
        if (root == null) {
            return;
        }
        if(root.val == subRoot.val){
            if (isSameTree(root, subRoot)) 
                ans = true;
                return;
            }
        } 
        // Perform some operation on the current node
        // Traverse the left subtree
        traverse(root.left , subRoot);
        // Traverse the right subtree
        traverse(root.right , subRoot);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
       
        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            } 
            if(!isSameTree(p.left, q.left)){
                return false;
            }
            if(!isSameTree(p.right, q.right)){
                return false;
            }
        }
        else{
            return false;
        }
        
        return true;
    }
}
```


* **Time complexity：O(n)** 
* **Space complexity:O(1)**

![](https://i.imgur.com/Npe3hdQ.png)

