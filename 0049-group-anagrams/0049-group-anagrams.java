import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, ArrayList<String>> map = new HashMap<>();

        for( String s: strs ){

            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            ArrayList<String> ll = map.getOrDefault( sortedStr,
                                     new ArrayList<String>() );
            ll.add(s);
            map.put( sortedStr, ll );
                                 
        }

        List<List<String>> ans = new ArrayList<>();
        for( Map.Entry<String, ArrayList<String>> entry: map.entrySet() ){
            ans.add( entry.getValue() );
        }

        return ans;
    }

}