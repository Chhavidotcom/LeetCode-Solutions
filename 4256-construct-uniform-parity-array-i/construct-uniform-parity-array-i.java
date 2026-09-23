class Solution {
    public boolean uniformArray(int[] nums1) {

        int odd = 0;
        int even = 0;

        for (int num : nums1) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        // Already uniform
        if (odd == 0 || even == 0) {
            return true;
        }

        // If both parities exist, choose one number
        // and subtract a number of opposite parity.
        return true;
    }
}