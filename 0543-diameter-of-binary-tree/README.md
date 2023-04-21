<h2><a href="https://leetcode.com/problems/diameter-of-binary-tree/">543. Diameter of Binary Tree</a></h2><h3>Easy</h3><hr><div><p>Given the <code>root</code> of a binary tree, return <em>the length of the <strong>diameter</strong> of the tree</em>.</p>

<p>The <strong>diameter</strong> of a binary tree is the <strong>length</strong> of the longest path between any two nodes in a tree. This path may or may not pass through the <code>root</code>.</p>

<p>The <strong>length</strong> of a path between two nodes is represented by the number of edges between them.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;">
<pre><strong>Input:</strong> root = [1,2,3,4,5]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 3 is the length of the path [4,2,1,3] or [5,2,1,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1,2]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>
</div>


<h2>解法：DFS</h2>

**Main idea**:因為diameter可能出現在不同子樹，也可能出現在同一子樹，所以：
* 出現在不同子樹：代表是左子樹高+右子樹高+2(假設子樹都存在)
* 相同子樹高：則需要計算子樹的root的左右子樹高度相加

所以總共需要計算兩個結果
1. 最大深度 => 提供出現在不同子樹的計算
2. 左右子樹高度相加
在code中使用res紀錄res左右子樹相加的最大值=>找出每個子點左右子樹相加的最大值
並比較父點的左右子樹高相加是更大。

```

class Solution {

    int result = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode current) {
        if (current == null) {
            return -1;
        }
        int left = 1 + dfs(current.left);
        int right = 1 + dfs(current.right);
        result = Math.max(result, (left + right));
        return Math.max(left, right);
    }
}
```

值得注意的是如果有一子樹是null時則代表不需要有路線到該子樹，但是在我們的公式:左子樹高+右子樹高+2中已經預設有左右子樹所以如果子樹是null時會回傳-1將抵銷多計算的長度。

* **Time complexity：O(n)** //因為要跑過所有節點 
* **Space complexity:O(1)**

![](https://i.imgur.com/yd1eDkL.png)




