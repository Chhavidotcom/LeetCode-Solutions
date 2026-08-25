class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int x: nums){
            maxheap.add(x);
        }

        int ans=0;

        while(k!=0){
            ans = maxheap.remove();
            k--;
        }
        return ans;
    }
}