class Solution {

    int mod = 1337;

    public int superPow(int a, int[] b) {

        int result = 1;

        for (int digit : b) {

            result = power(result, 10) * power(a, digit) % mod;
        }

        return result;
    }

    int power(int a, int n) {

        int result = 1;
        a = a % mod;

        while (n > 0) {

            if (n % 2 == 1) {
                result = result * a % mod;
            }

            a = a * a % mod;
            n = n / 2;
        }

        return result;
    }
}