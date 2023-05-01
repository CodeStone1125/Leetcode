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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return Valid(root, null, null);
    }
    public boolean Valid(TreeNode root, Integer left, Integer right) { //Integer是一個物件所以可以是null
        if(root == null){
            return true;
        }
        if(((left!=null)&&(left>=root.val))||((right!=null)&&(right<=root.val))){
            return false;
        }
        return Valid(root.left, left,root.val)&&Valid(root.right, root.val, right);
    }
}