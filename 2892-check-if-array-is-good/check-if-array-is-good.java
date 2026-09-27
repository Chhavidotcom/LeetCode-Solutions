class Solution {
    public boolean isGood(int[] nums) {

        int n = nums.length - 1;

        int[] count = new int[n + 1];

        for (int num : nums) {
            if (num > n) {
                return false;
            }

            count[num]++;
        }

        // 1 to n-1 should appear exactly once
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) {
                return false;
            }
        }

        // n should appear exactly twice
        return count[n] == 2;
    }
}