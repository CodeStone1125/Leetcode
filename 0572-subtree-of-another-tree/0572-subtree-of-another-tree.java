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
            if (isSameTree(root, subRoot)) {

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