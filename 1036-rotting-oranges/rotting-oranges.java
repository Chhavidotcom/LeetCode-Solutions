class Solution {
    public int orangesRotting(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        int ans =0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int time= curr[2];

            ans= Math.max(ans,time);

           // Top
if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
    q.offer(new int[]{i - 1, j, time + 1});
    vis[i - 1][j] = true;
}

// Right
if (j + 1 < m && !vis[i][j + 1] && grid[i][j + 1] == 1) {
    q.offer(new int[]{i, j + 1, time + 1});
    vis[i][j + 1] = true;
}

// Bottom
if (i + 1 < n && !vis[i + 1][j] && grid[i + 1][j] == 1) {
    q.offer(new int[]{i + 1, j, time + 1});
    vis[i + 1][j] = true;
}

// Left
if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
    q.offer(new int[]{i, j - 1, time + 1});
    vis[i][j - 1] = true;
}
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if((grid[i][j]==1)&&(!vis[i][j])){
                    return -1;
                }



    }
}
return ans;
    }}