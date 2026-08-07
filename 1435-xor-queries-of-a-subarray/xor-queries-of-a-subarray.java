class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int nums[]=new int[arr.length];
        nums[0]=arr[0];
        for(int i=1;i<arr.length;i++){

            nums[i]=nums[i-1]^arr[i];

        }
        int ans[]=new int[queries.length];
        for(int i =0;i<queries.length;i++){
            int left=queries[i][0];
            int right= queries[i][1];

            if(left==0)
            ans[i]=nums[right];
            else
            ans[i]=nums[right]^nums[left-1];
        }
        return ans;
    }
}