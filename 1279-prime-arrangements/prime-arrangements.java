class Solution {
    public int numPrimeArrangements(int n) {

        long MOD = 1000000007;
        int primeCount = 0;

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }

        long primeWays = 1;

        for (int i = 1; i <= primeCount; i++) {
            primeWays = (primeWays * i) % MOD;
        }

        int nonPrimeCount = n - primeCount;

        long nonPrimeWays = 1;

        for (int i = 1; i <= nonPrimeCount; i++) {
            nonPrimeWays = (nonPrimeWays * i) % MOD;
        }

        long answer = (primeWays * nonPrimeWays) % MOD;

        return (int) answer;
    }

    boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}