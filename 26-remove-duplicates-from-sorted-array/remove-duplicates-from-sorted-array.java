class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer,Integer>map = new LinkedHashMap<>();
        for(int i =0;i<nums.length;i++){
           map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int j = 0;
        for (Integer i:map.keySet()){
            nums[j] = i;
            j++;
        }
        
        return j;
    }
}