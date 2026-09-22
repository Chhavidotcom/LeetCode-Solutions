class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            int rem = num % k;

            long[] next = new long[k];

            // Start a new subarray with current element
            next[rem]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newRem = (int) ((long) r * rem % k);

                next[newRem] += dp[r];
            }

            // Add all subarrays ending at current index
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }
}