class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n =nums1.length;
        int m=nums2.length;
        int k=0;
        int[] arr= new int[Math.min(n,m)];
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++)
        {
            if (nums2[j]==nums1[i]){
                nums2[j]=-1;
            arr[k] = nums1[i];
            k++;
            break;}

        }
      }
      return Arrays.copyOf(arr, k);
    }
}