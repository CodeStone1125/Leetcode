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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        bfs(ans, root);
        return ans;
    }
    public void bfs(List<Integer> ans, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // System.out.println("root " + root.val);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=levelSize;i>=1;i--){ //BFS
                TreeNode cur = q.poll();
                if(i==1) {
                    ans.add(cur.val);
                    // System.out.println("ans加入 " + cur.val);
                } //加入最右邊的元素
                if(cur.left !=null ) {
                    q.add(cur.left); 
                    // System.out.println("加入 " + cur.left.val);
                }
                if(cur.right !=null ) {
                    q.add(cur.right); 
                    // System.out.println("加入 " + cur.right.val);
                }
            }
            
        }
        
    }
}