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
    Map<Integer, List<Integer>> map = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root, 1);
        List<List<Integer>> listOfLists = new ArrayList<>(map.values());
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> list : listOfLists) {
            int lastIndex = list.size() - 1;
            int lastElement = list.get(lastIndex);
            ans.add(lastElement);
        }       
        return ans;
        
    }
   public void traverse(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        // Print the height of the current node
        List<Integer> temp = map.getOrDefault(height,new ArrayList<Integer>());
        temp.add(root.val);
        map.put(height,temp);
        // Traverse the left subtree
        traverse(root.left, height + 1);
        // Traverse the right subtree
        traverse(root.right, height + 1);
    }
}