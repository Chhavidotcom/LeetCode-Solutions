class Solution {

    public int maxPathScore(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][cost] = maximum score
        // reaching (i,j) with exact cost
        int[][][] dp = new int[m][n][k + 1];

        // -1 means this state is not reachable
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        // Starting cell
        int startCost = grid[0][0] == 0 ? 0 : 1;
        int startScore = grid[0][0];

        if (startCost <= k) {
            dp[0][0][startCost] = startScore;
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                // Starting cell already initialized
                if (i == 0 && j == 0) {
                    continue;
                }

                int cellCost = grid[i][j] == 0 ? 0 : 1;
                int cellScore = grid[i][j];

                for (int cost = cellCost; cost <= k; cost++) {

                    int previousCost = cost - cellCost;

                    // From top
                    if (i > 0 &&
                        dp[i - 1][j][previousCost] != -1) {

                        dp[i][j][cost] = Math.max(
                            dp[i][j][cost],
                            dp[i - 1][j][previousCost]
                                + cellScore
                        );
                    }

                    // From left
                    if (j > 0 &&
                        dp[i][j - 1][previousCost] != -1) {

                        dp[i][j][cost] = Math.max(
                            dp[i][j][cost],
                            dp[i][j - 1][previousCost]
                                + cellScore
                        );
                    }
                }
            }
        }

        // Destination par cost <= k allowed hai
        int answer = -1;

        for (int cost = 0; cost <= k; cost++) {
            answer = Math.max(
                answer,
                dp[m - 1][n - 1][cost]
            );
        }

        return answer;
    }
}