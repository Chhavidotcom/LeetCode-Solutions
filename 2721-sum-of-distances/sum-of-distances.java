import java.util.*;

class Solution {
    public long[] distance(int[] nums) {

        int n = nums.length;
        long[] ans = new long[n];

        // value -> sum of indices
        Map<Integer, Long> sum = new HashMap<>();

        // value -> count
        Map<Integer, Integer> count = new HashMap<>();

        // Left se right ja rahe hain
        for (int i = 0; i < n; i++) {

            int value = nums[i];

            long indexSum = sum.getOrDefault(value, 0L);
            int cnt = count.getOrDefault(value, 0);

            /*
             * Current index i ke left mein same value
             *
             * Distance:
             * (i - j)
             *
             * Sabka sum:
             * cnt * i - sumOfIndices
             */
            ans[i] += (long) cnt * i - indexSum;

            // Current index ko add karo
            sum.put(value, indexSum + i);
            count.put(value, cnt + 1);
        }

        // Right se left ja rahe hain
        sum.clear();
        count.clear();

        for (int i = n - 1; i >= 0; i--) {

            int value = nums[i];

            long indexSum = sum.getOrDefault(value, 0L);
            int cnt = count.getOrDefault(value, 0);

            /*
             * Right side ke same values:
             *
             * j - i
             *
             * Sum:
             * sumOfIndices - cnt * i
             */
            ans[i] += indexSum - (long) cnt * i;

            // Current index ko add karo
            sum.put(value, indexSum + i);
            count.put(value, cnt + 1);
        }

        return ans;
    }
}