class Solution {
    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i =0;i<32;i++){
            int count0=0;
            int count1=0;
            for(int j =0;j<nums.length;j++)
{
    if((nums[j]&(1<<i))==0){
        count0++;
    }
    else{
        count1++;
    }
}  

if(count1 % 3 == 1) {

                if(i == 31) {
                    ans = ans + Integer.MIN_VALUE;
                }
                else {
                    ans = ans + (int)Math.pow(2, i);
                }
    
    }
        }
      return ans;}
}