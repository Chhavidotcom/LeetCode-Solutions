class Solution {

    public long maximumScore(int[][] grid) {

        int n = grid.length;

        if (n == 1) {
            return 0;
        }

        // prefix[col][k] = column 'col' ke first k elements ka sum
        long[][] prefix = new long[n][n + 1];

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                prefix[col][row + 1] =
                    prefix[col][row] + grid[row][col];
            }
        }

        long NEG = -(1L << 60);

        /*
         * dp[a][b]:
         *
         * previous column ki height = a
         * current column ki height  = b
         */
        long[][] dp = new long[n + 1][n + 1];

        // First column
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n; b++) {

                dp[a][b] = Math.max(
                    0L,
                    prefix[0][b] - prefix[0][a]
                );
            }
        }

        // Remaining columns
        for (int col = 1; col < n; col++) {

            long[][] ndp = new long[n + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                java.util.Arrays.fill(ndp[i], NEG);
            }

            /*
             * mid = current column ki height
             */
            for (int mid = 0; mid <= n; mid++) {

                /*
                 * q[x] =
                 * current column ke rows [mid, x) ka sum
                 */
                long[] q = new long[n + 1];

                for (int x = 0; x <= n; x++) {
                    q[x] = Math.max(
                        0L,
                        prefix[col][x] - prefix[col][mid]
                    );
                }

                /*
                 * prefixBest[x] =
                 * max(dp[a][mid]) for a <= x
                 */
                long[] prefixBest = new long[n + 1];

                prefixBest[0] = dp[0][mid];

                for (int a = 1; a <= n; a++) {
                    prefixBest[a] = Math.max(
                        prefixBest[a - 1],
                        dp[a][mid]
                    );
                }

                /*
                 * suffixBest[x] =
                 * max(dp[a][mid] + q[a]) for a >= x
                 */
                long[] suffixBest = new long[n + 2];

                java.util.Arrays.fill(suffixBest, NEG);

                suffixBest[n] = dp[n][mid] + q[n];

                for (int a = n - 1; a >= 0; a--) {

                    suffixBest[a] = Math.max(
                        suffixBest[a + 1],
                        dp[a][mid] + q[a]
                    );
                }

                /*
                 * Next column ki height.
                 *
                 * Last column ke baad imaginary
                 * column ki height = 0.
                 */
                int limit = (col == n - 1) ? 0 : n;

                for (int next = 0; next <= limit; next++) {

                    long best = NEG;

                    /*
                     * Previous height <= next
                     */
                    if (prefixBest[next] != NEG) {

                        best = Math.max(
                            best,
                            prefixBest[next] + q[next]
                        );
                    }

                    /*
                     * Previous height > next
                     */
                    if (suffixBest[next + 1] != NEG) {

                        best = Math.max(
                            best,
                            suffixBest[next + 1]
                        );
                    }

                    ndp[mid][next] = best;
                }
            }

            dp = ndp;
        }

        long answer = 0;

        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n; b++) {
                answer = Math.max(answer, dp[a][b]);
            }
        }

        return answer;
    }
}