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
        if(list.size() == 0) return true;
        if(VisitSet.contains(list.get(0))) return false;
        while(list.size()!= 0){
            int x = list.remove(0);
            VisitSet.add(x);
            Map.put(num,list);
            if(!check(x, Map, VisitSet)) return false;
            VisitSet.remove(x);
        }
        return true;
    }
}

            
