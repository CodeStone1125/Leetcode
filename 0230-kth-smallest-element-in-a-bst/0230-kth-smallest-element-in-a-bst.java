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
    int kmin = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        ldr(root, k); 
        return kmin;
        
    }
    public void ldr(TreeNode root,int k){
        if(root==null){
            return;
        }
        
        ldr(root.left, k);
        count++;
        if(count==k){
            kmin = root.val;
            return;
        }
        ldr(root.right, k);
        
    }
}