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
    TreeNode temp;
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        else if((root.left==null) && (root.right==null)){
            return root;
        }
        else{
            invertTree(root.left);
            invertTree(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}