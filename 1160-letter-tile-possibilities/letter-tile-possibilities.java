class Solution {
    public int numTilePossibilities(String tiles) {

        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        tiles = new String(arr);

        boolean[] used = new boolean[tiles.length()];

        return solve(tiles, used);
    }

    public int solve(String tiles, boolean[] used) {

        int count = 0;

        for (int i = 0; i < tiles.length(); i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && tiles.charAt(i) == tiles.charAt(i - 1)
                    && !used[i - 1]) {
                continue;
            }

            used[i] = true;

            count++;

            count += solve(tiles, used);

            used[i] = false;
        }

        return count;
    }
}