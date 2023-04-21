/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return searchBST(root, Math.min(p.val,q.val), Math.max(p.val,q.val));
    }
    public TreeNode searchBST(TreeNode root, int p, int q){
        if (root == null || (root.val >= p && root.val <= q)) {
            return root;
        }
        
        else if (q < root.val||p < root.val) {
            return searchBST(root.left, p , q);
        } 
        else if (q > root.val||p > root.val){
            return searchBST(root.right, p , q);
        }

        return root;
    }
}