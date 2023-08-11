class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> Map = new HashMap<>(numCourses);
        List<Integer> list = new ArrayList<Integer>();
        for(int i= 0; i< numCourses; i++){
            Map.put(i,new ArrayList<Integer>());
        }
        //put all prerequisites in hashmap
        for (int[] num : prerequisites) {
            list = Map.getOrDefault(num[0], new ArrayList<Integer>());
            list.add(num[1]);
            Map.put(num[0],list);
        }
        // // 使用 entrySet() 方法遍历 HashMap
        // for (Map.Entry<Integer, List<Integer>> entry : Map.entrySet()) {
        //     int key = entry.getKey();
        //     List<Integer> values = entry.getValue();
        //     System.out.println("Key: " + key + ", Values: " + values);
        // }
        
        //check all courses
        
        for(int i= 0; i< numCourses; i++){
            HashSet<Integer> VisitSet = new HashSet<>();
            VisitSet.add(i);
            if(!check(i, Map, VisitSet)) return false;
        }
        return true;
    }
    public boolean check(int num, HashMap<Integer, List<Integer>> Map, HashSet<Integer> VisitSet){
        List<Integer> list = Map.getOrDefault(num, new ArrayList<Integer>());
        if(list.size() == 0){
            return true;
        }
        if(VisitSet.contains(list.get(0))){
            // System.out.printf("%d:",num);
            // System.out.println(Arrays.toString(list.toArray()));
            return false;
        } 
        
        while(list.size()!= 0){
            int x = list.remove(0);
            VisitSet.add(x);
            // Iterator itr = VisitSet.iterator();
            // while (itr.hasNext()) {
            //     System.out.printf(" %d ",itr.next());
            // }
            // System.out.println();
            Map.put(num,list);
            if(!check(x, Map, VisitSet)) return false;
            VisitSet.remove(x);
        }
        return true;
    }
}

            
