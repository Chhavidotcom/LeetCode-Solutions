class Solution {
    public int maxArea(int[] height) {
        int st=0;
        int end = height.length-1;
       int ans = Integer.MIN_VALUE;
        int area=0;

        while(st<=end){
            area= (end-st)*(Math.min(height[end],height[st]));
            ans = Math.max(ans,area);
            if(height[end]>height[st]){
                st++;
            }
            else{
                end--;
            }
        }
return ans;
    }
}