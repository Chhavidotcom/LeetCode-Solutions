class Solution {

    HashSet<Integer> seen = new HashSet<>();

    public boolean isHappy(int n) {

        if (n == 1) {
            return true;
        }

        if (seen.contains(n)) {
            return false;
        }

        seen.add(n);

        int sum = sumOfSquares(n);

        return isHappy(sum);
    }

    public int sumOfSquares(int n) {

        if (n == 0) {
            return 0;
        }

        int digit = n % 10;

        return digit * digit + sumOfSquares(n / 10);
    }
}