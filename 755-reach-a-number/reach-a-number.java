class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);

        int start = 0;

        for (int i = 1; ; i++) {

            start = start + i;

            if (start >= target && (start - target) % 2 == 0) {
                return i;
            }
        }
    }
}