class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       int count=0;
        for(int i=0;i<m;i++)
        {
             int start=0;
        int end = n-1;
        while(start<=end){
            int mid =start+(end-start)/2;
            if(grid[i][mid]<0){
                
                end=mid-1;
            }
            else {
               start=mid+1;
            }
           
        }
 count = count+ n-start;
        }
        return count;
    }
}