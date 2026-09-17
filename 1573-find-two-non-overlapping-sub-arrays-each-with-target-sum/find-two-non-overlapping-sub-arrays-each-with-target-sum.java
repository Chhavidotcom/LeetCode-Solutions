class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        int[] best = new int[n];

        int INF = Integer.MAX_VALUE / 2;

        int ans = INF;

        int left = 0;
        int sum = 0;

        int bestSoFar = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Carry forward previous best
            if (right > 0) {
                best[right] = best[right - 1];
            } else {
                best[right] = INF;
            }

            // Found a target-sum subarray
            if (sum == target) {

                int currentLength = right - left + 1;

                // Check if there is a non-overlapping
                // target subarray before 'left'
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(
                        ans,
                        currentLength + best[left - 1]
                    );
                }

                // Update best
                best[right] = Math.min(
                    best[right],
                    currentLength
                );
            }
        }

        return ans == INF ? -1 : ans;
    }
}