class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     int[] merged = new int[m+n];
     int index1= 0;
     int index2= 0;
     int x=0;   
     while(index1<m && index2<n){
        if(nums1[index1]<=nums2[index2]){
            merged[x++]= nums1[index1++];
        }
        else{
             merged[x++]= nums2[index2++];
        }

     }
     while(index1<m){
         merged[x++]= nums1[index1++];
     }
     while(index2<n){
         merged[x++]= nums2[index2++];
     }

     for(int i =0,j=0;i<merged.length;i++,j++){
        nums1[j]=merged[i];
     }
     
    }
}