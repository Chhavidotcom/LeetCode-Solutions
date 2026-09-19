import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {

        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m * n];
        int k = 0;

        // 2D grid -> 1D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k++] = grid[i][j];
            }
        }

        // Check if possible
        int rem = arr[0] % x;

        for (int num : arr) {
            if (num % x != rem) {
                return -1;
            }
        }

        // Sort
        Arrays.sort(arr);

        // Median
        int median = arr[arr.length / 2];

        int operations = 0;

        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}