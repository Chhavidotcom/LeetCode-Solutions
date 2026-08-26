class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int[] i : points){
            int x = i[0];
            int y = i[1];

            int distance = x*x + y*y;
            pq.add(new int[]{distance, x, y});
             if (pq.size() > k) {
               pq.poll();
    }}
    int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {

            int[] point = pq.poll();

            result[i][0] = point[1];
            result[i][1] = point[2]; 
        }
        
return result;



    }
}