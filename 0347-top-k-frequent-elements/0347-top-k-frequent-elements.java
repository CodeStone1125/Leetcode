class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for( int i: nums ){
            int ll = map.getOrDefault( i, 0 );
            map.put( i, ll+1 );                
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }     
        return ans;
    }

}