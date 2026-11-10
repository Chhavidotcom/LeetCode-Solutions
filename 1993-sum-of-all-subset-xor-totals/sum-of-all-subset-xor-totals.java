class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums,0,0);
        
    }
    int solve(int[] nums, int i , int xor){
        if(i==nums.length){
            return xor;
        }

     int take=   solve(nums,i+1,xor^nums[i]);
     int notake= solve(nums,i+1,xor);

     return take+notake;
    }
}