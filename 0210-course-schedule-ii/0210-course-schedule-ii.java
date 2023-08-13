

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
        return true;
    }
}

            
