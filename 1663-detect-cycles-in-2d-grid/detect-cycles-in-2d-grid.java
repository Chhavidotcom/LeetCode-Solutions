class Solution {

    int m, n;
    char[][] grid;
    boolean[][] visited;

    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public boolean containsCycle(char[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (!visited[r][c]) {

                    if (dfs(r, c, -1, -1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int parentR, int parentC) {

        visited[r][c] = true;

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            // Out of bounds
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }

            // Different character
            if (grid[nr][nc] != grid[r][c]) {
                continue;
            }

            // Parent cell hai -> ignore
            if (nr == parentR && nc == parentC) {
                continue;
            }

            // Already visited same-value cell
            // and it's NOT parent -> cycle
            if (visited[nr][nc]) {
                return true;
            }

            // DFS
            if (dfs(nr, nc, r, c)) {
                return true;
            }
        }

        return false;
    }
}