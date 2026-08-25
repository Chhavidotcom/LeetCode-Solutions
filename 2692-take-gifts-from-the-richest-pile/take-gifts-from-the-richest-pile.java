class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        for(int x : gifts){
            maxHeap.add(x);
        }

        while(k>0){


           int max= maxHeap.remove();
           int rootnumber = (int) Math.sqrt(max);

           maxHeap.add(rootnumber);
           k--;

        }

        long ans =0;
        while(!maxHeap.isEmpty()){
            ans+=maxHeap.remove();
        }
return ans;
    }
}