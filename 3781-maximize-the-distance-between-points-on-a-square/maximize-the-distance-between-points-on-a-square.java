import java.util.*;

class Solution {

    public int maxDistance(int side, int[][] points, int k) {

        int n = points.length;

        // Square ke boundary ko 1D line mein convert karo
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {

            int x = points[i][0];
            int y = points[i][1];

            if (x == 0) {
                // Left edge
                arr[i] = y;
            } 
            else if (y == side) {
                // Top edge
                arr[i] = side + x;
            } 
            else if (x == side) {
                // Right edge
                arr[i] = 3L * side - y;
            } 
            else {
                // Bottom edge
                arr[i] = 4L * side - x;
            }
        }

        Arrays.sort(arr);

        // Maximum possible answer side se zyada nahi ho sakta
        int low = 0;
        int high = side;

        while (low < high) {

            int mid = low + (high - low + 1) / 2;

            if (canPlace(arr, side, k, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean canPlace(long[] arr, int side, int k, long dist) {

        int n = arr.length;
        long perimeter = 4L * side;

        // Circular array ko duplicate kar diya
        long[] extended = new long[2 * n];

        for (int i = 0; i < n; i++) {
            extended[i] = arr[i];
            extended[i + n] = arr[i] + perimeter;
        }

        /*
         * Har point ko starting point maan ke try karo.
         */
        for (int start = 0; start < n; start++) {

            int count = 1;
            long current = extended[start];

            /*
             * Last selected point ko itna aage nahi jaane dena
             * ki starting point ke saath wrap-around distance
             * dist se kam ho jaye.
             */
            long limit = current + perimeter - dist;

            int index = start + 1;

            while (count < k && index < start + n) {

                // Next point jo current + dist se >= ho
                while (index < start + n &&
                       extended[index] < current + dist) {
                    index++;
                }

                if (index >= start + n) {
                    break;
                }

                if (extended[index] > limit) {
                    break;
                }

                current = extended[index];
                count++;
                index++;
            }

            if (count == k) {
                return true;
            }
        }

        return false;
    }
}