class Solution {

    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        return solve(n, k, numbers);
    }

    String solve(int n, int k, List<Integer> numbers) {

        // Base case
        if (n == 1) {
            return String.valueOf(numbers.get(0));
        }

        // (n-1)!
        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact = fact * i;
        }

        // k ko 0-indexed
        k--;

        // kaunsa number first aayega
        int index = k / fact;

        int first = numbers.get(index);

        // number remove
        numbers.remove(index);

        // remaining group ke andar k
        k = k % fact;

        // recursion
        return first + solve(n - 1, k + 1, numbers);
    }
}