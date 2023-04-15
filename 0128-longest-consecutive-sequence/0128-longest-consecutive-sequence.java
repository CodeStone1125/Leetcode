import java.util.Hashtable;
class Solution {
    public int longestConsecutive(int[] nums) {
        int[] sorted_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted_nums);
        Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
        int Max=0;
        for(int num:sorted_nums){
            hashTable.put(num, 1);
        }
        for(int num:sorted_nums){
            int value = hashTable.getOrDefault(num-1,0);
            hashTable.put(num,value+1);
            if(Max<(value+1))
            {
                Max=value+1;
            }
        }
        return Max;
    }
}