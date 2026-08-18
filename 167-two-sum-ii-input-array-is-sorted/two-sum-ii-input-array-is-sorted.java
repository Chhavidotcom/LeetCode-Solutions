class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer>map= new HashMap<>();
        for(int i =0;i<numbers.length;i++){
            int ele= target-numbers[i];
            if(map.containsKey(ele))
            {
                return new int[]{map.get(ele)+1,i+1};
            }
            
                map.put(numbers[i],i);
            

        }
        return new int[]{-1,-1};
    }
}