class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int st=0, end=0, curr=0;
     int ans = Integer.MAX_VALUE;

     while(end< nums.length){
        curr +=nums[end];
        end++;
        while(curr>=target){
            ans = Math.min(ans,end-st);
            curr=curr-nums[st];
            st++;
        }
     }
     return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}