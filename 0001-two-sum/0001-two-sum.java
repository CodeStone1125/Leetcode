class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        int[] output = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                output[0] = map.get(nums[i]);
                output[1] = i;
                return output;
            }
            map.put(target - nums[i], i);
        }
        return output;
    }
}