class Solution {
    public int countCommas(int n) {

        int ans = 0;

        // 1,000 to 999,999 -> 1 comma
        if (n >= 1000) {
            ans += Math.min(n, 999999) - 1000 + 1;
        }

        // 1,000,000 to 999,999,999 -> 2 commas
        if (n >= 1000000) {
            ans += 2 * (Math.min(n, 999999999) - 1000000 + 1);
        }

        // 1,000,000,000 onwards -> 3 commas
        if (n >= 1000000000) {
            ans += 3 * (n - 1000000000 + 1);
        }

        return ans;
    }
}