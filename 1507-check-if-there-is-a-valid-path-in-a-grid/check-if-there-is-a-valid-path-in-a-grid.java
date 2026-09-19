class Solution {

    int m, n;

    public boolean hasValidPath(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int r, int c,
                        boolean[][] visited) {

        // Destination
        if (r == m - 1 && c == n - 1) {
            return true;
        }

        visited[r][c] = true;

        int type = grid[r][c];

        // Up
        if (type == 2 || type == 5 || type == 6) {

            if (r - 1 >= 0 &&
                !visited[r - 1][c] &&
                (grid[r - 1][c] == 2 ||
                 grid[r - 1][c] == 3 ||
                 grid[r - 1][c] == 4)) {

                if (dfs(grid, r - 1, c, visited)) {
                    return true;
                }
            }
        }

        // Down
        if (type == 2 || type == 3 || type == 4) {

            if (r + 1 < m &&
                !visited[r + 1][c] &&
                (grid[r + 1][c] == 2 ||
                 grid[r + 1][c] == 5 ||
                 grid[r + 1][c] == 6)) {

                if (dfs(grid, r + 1, c, visited)) {
                    return true;
                }
            }
        }

        // Left
        if (type == 1 || type == 3 || type == 5) {

            if (c - 1 >= 0 &&
                !visited[r][c - 1] &&
                (grid[r][c - 1] == 1 ||
                 grid[r][c - 1] == 4 ||
                 grid[r][c - 1] == 6)) {

                if (dfs(grid, r, c - 1, visited)) {
                    return true;
                }
            }
        }

        // Right
        if (type == 1 || type == 4 || type == 6) {

            if (c + 1 < n &&
                !visited[r][c + 1] &&
                (grid[r][c + 1] == 1 ||
                 grid[r][c + 1] == 3 ||
                 grid[r][c + 1] == 5)) {

                if (dfs(grid, r, c + 1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}