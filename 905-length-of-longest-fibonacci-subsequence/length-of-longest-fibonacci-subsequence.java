class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int max = 0;

        for(int k = 0; k < n; k++) {
            for(int j = 0; j < k; j++) {
                int need = arr[k] - arr[j];

                if(map.containsKey(need)) {
                    int i = map.get(need);

                    if(i < j) {
                        dp[j][k] = dp[i][j] + 1;
                    }
                }

                if(dp[j][k] == 0) {
                    dp[j][k] = 2;
                }

                max = Math.max(max, dp[j][k]);
            }
        }

        return max >= 3 ? max : 0;
    }
}