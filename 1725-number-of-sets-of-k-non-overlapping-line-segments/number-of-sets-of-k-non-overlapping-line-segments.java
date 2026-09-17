class Solution {
    static final long MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        
        long[][] dp = new long[N + 1][2 * k + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 2 * k; j++) {

                // Don't choose this position
                dp[i][j] = dp[i - 1][j];

                // Choose this position
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }

        return (int) dp[N][2 * k];
    }
}