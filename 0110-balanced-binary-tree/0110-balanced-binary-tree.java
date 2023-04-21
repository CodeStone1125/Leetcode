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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>=2){
            return false;
        }
        if(!isBalanced(root.left)){
            return false;
        }
        if(!isBalanced(root.right)){
            return false;
        }
        
        return true;
        
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else if(root.left==null && root.right==null){
            return 1;
        }
        
        else{
            return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
        }
        
    }
}