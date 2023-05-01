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
    int good = 0;
    public int goodNodes(TreeNode root) {
        if(root == null)
        {
            return good;
        }
        else{
            good=1;   
        }
        count(root, Double.NEGATIVE_INFINITY);
        return good;
    }
    public void count(TreeNode root, Double max) {
        if(root == null)
        {
            return;
        }
        if(root.val > max){
            max = Double.valueOf(root.val);
        }
        if((root.right!=null)&&(root.right.val >= max)){
            good++;
        }
        if((root.left!=null)&&(root.left.val >= max)){
            good++;
        }
        count(root.left, max);
        count(root.right, max);
    }
}