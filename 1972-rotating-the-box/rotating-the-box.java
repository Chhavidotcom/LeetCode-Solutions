class Solution {

    public char[][] rotateTheBox(char[][] boxGrid) {

        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Step 1: Stones ko right ki taraf girao
        for (int r = 0; r < m; r++) {

            int empty = n - 1;

            for (int c = n - 1; c >= 0; c--) {

                if (boxGrid[r][c] == '*') {

                    // Obstacle ke baad next available position
                    empty = c - 1;

                } else if (boxGrid[r][c] == '#') {

                    // Stone ko empty position par shift karo
                    boxGrid[r][c] = '.';

                    boxGrid[r][empty] = '#';

                    empty--;
                }
            }
        }

        // Step 2: 90 degree clockwise rotation
        char[][] result = new char[n][m];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                result[c][m - 1 - r] = boxGrid[r][c];
            }
        }

        return result;
    }
}