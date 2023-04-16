class Solution {
    public int characterReplacement(String s, int k) {
        int Max=0;
        int l=0;
        HashMap<Character, Integer> count = new HashMap<>();
        for(int r=0;r<s.length();r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            while(((r-l+1)-getMaxValue(count))>k)
            {
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;     
                
            }
            Max=Math.max(r-l+1,Max);  
         }

         return Max;      
    }
    public static <K, V extends Comparable<V>> V getMaxValue(Map<K, V> map) {
        V maxValue = null;
        for (V value : map.values()) {
            if (maxValue == null || value.compareTo(maxValue) > 0) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}

