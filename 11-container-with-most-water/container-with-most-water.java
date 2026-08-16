class Solution {
    public int maxArea(int[] height) {
        int start=0;
        int end= height.length-1;
        int ans=0;
    
        while(start<end)
        {
            int width = end-start;
            int ht=Math.min(height[start],height[end]);
            int area= width*ht;
            if (ans<area)
            {
                ans=area;
               
            }
            if(ht==height[end])
            {
                end--;
            }
            else
            {
                start++;
            }
         
            

        }
        return ans;

    }
}