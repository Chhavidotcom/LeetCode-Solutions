class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for (int num = 100; num <= 998; num += 2) {

            int n = num;

            int ones = n % 10;
            n /= 10;

            int tens = n % 10;
            n /= 10;

            int hundreds = n;

            int[] used = new int[10];

            used[hundreds]++;
            used[tens]++;
            used[ones]++;

            boolean possible = true;

            for (int d = 0; d <= 9; d++) {
                if (used[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}