/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    List<Node> visit = new ArrayList<Node>();
    HashMap<Node, Node> nodeMap = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        bfs_node(node);
        visit = new ArrayList<Node>();
        bfs_nbr(node);
        return nodeMap.getOrDefault(node, new Node());
    }
    
    public void bfs_node(Node node){
        nodeMap.put(node, new Node(node.val));
        Queue<Node> queue = new LinkedList<>();
        visit.add(node);
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            for(Node n: temp.neighbors){
                if(!visit.contains(n)){
                    queue.add(n);
                    visit.add(n);
                    nodeMap.put(n, new Node(n.val));
                }
            }
            
        }
        return;
    }
    
    public void bfs_nbr(Node node){
        Queue<Node> queue = new LinkedList<>();
        visit.add(node);
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            Node temp_copy = nodeMap.getOrDefault(temp, new Node());
            for(Node n: temp.neighbors){
                if(!visit.contains(n)){
                    queue.add(n);
                    visit.add(n);
                }
                temp_copy.neighbors.add(nodeMap.getOrDefault(n, new Node()));
            }
            
        }
        return;
    }
}