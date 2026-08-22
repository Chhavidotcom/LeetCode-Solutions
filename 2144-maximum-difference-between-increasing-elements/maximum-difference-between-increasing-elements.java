class Solution {
    public int maximumDifference(int[] nums) {

        int m = nums.length - 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {

            for (int j = i + 1; j <= m; j++) {

                if (nums[i] < nums[j]) {

                    int diff = nums[j] - nums[i];

                    ans = Math.max(ans, diff);
                }
            }
        }

        if (ans == Integer.MIN_VALUE) {
            return -1;
        }

        return ans;
    }
}