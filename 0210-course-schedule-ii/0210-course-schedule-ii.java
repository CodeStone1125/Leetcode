// class Solution {
    
//     ArrayList[] graph;
    
    
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
        
//         //intialize graph 
//         graph = new ArrayList[numCourses];
//         for(int i = 0; i < numCourses; i++){
//             graph[i] = new ArrayList();
//         }
        
        
//         //construct graph
//         for(int[] num:prerequisites){
//             graph[num[1]].add(num[0]);
//         }
           
        
//         //construct 4 set
//         Set<Integer> whiteset = new HashSet<Integer>();
//         Set<Integer> grayset = new HashSet<Integer>();
//         Set<Integer> blackset = new HashSet<Integer>();
        
        
//         //intialize whiteset
//         for(int i = 0; i < numCourses; i++){
//             whiteset.add(i);
//         }
        
            
//         //DFS for all class
//         List<Integer> order = new ArrayList<Integer>();
        
        
//         while(whiteset.size() > 0){
//             int temp = whiteset.iterator().next();
//             if(dfs(whiteset, grayset, blackset, order, temp)) return new Int[];
//         }
        
//         return order;
          
//     }
    
    
//     //Dfs
//     public boolean dfs(Set<Integer> whiteset, Set<Integer> grayset, Set<Integer> blackset, List<Integer> order, int temp){
        
//         order.add(temp);
        
//         //first shift items from white to gray
//         shiftitem(whiteset, grayset, temp);
        
        
//         //get the adjacency list of graph item
//         ArrayList<Integer> adj = graph[temp];
        
        
//         //track order
//         order.add(temp);
//         if(order.size() == numCourses) return false;
        
        
//         //check all nodes from adjacency list
//         for(int var: adj){
//             if(blackset.contains(var))
//                 continue;
//             if(grayset.contains(var))
//                 return true;
//             if((dfs(whiteset, grayset, blackset, order, var) ))
//                 return true;
    
//         }
//     }
    
    
//     //Change element
//     public void shiftitem(Set<Integer> set1, Set<Integer> set2, int item){
//         set1.remove(item);
//         set2.add(item);
//     }
// }

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
         
        //Initialize hashmap
        HashMap<Integer, List<Integer>> Map = new HashMap<>(numCourses);
        for(int i= 0; i< numCourses; i++){
            Map.put(i,new ArrayList<Integer>());
        }
        
        
        //put all prerequisites in hashmap
        List<Integer> list = new ArrayList<Integer>();
        for (int[] num : prerequisites) {
            list = Map.getOrDefault(num[0], new ArrayList<Integer>());
            list.add(num[1]);
            Map.put(num[0],list);
        }
        
        
        List<Integer> ans = new ArrayList<Integer>();
        
        
        //check all courses
        for(int i= 0; i< numCourses; i++){
            HashSet<Integer> VisitSet = new HashSet<>();
            VisitSet.add(i);
            if(!check(i, Map, VisitSet, ans)) return new int[0];
        }
        
        // Convert List<Integer> to int array
        int[] array = ans.stream().mapToInt(Integer::intValue).toArray();
        
        return array;

    }
    
    
    public boolean check(int num, HashMap<Integer, List<Integer>> Map, HashSet<Integer> VisitSet, List<Integer> ans){
        List<Integer> list = Map.getOrDefault(num, new ArrayList<Integer>());
        if(list.size() == 0){
            if(!ans.contains(num)){
                System.out.println("add");
                ans.add(num);
            }
            return true;
        }
        
        if(VisitSet.contains(list.get(0))) return false;
        
        
        while(list.size()!= 0){
            int x = list.remove(0);
            VisitSet.add(x);
            Map.put(num,list);
            if(!check(x, Map, VisitSet, ans)) return false;
            VisitSet.remove(x);
        }
        
        ans.add(num);
        System.out.println("finish");
        return true;
    }
}

            
