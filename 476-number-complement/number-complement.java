class Solution {
    public int findComplement(int num) {

        int ans = 0;
        int place = 1;

        while (num > 0) {

            if ((num & 1) == 0) {
                ans = ans + place;
            }

            num = num >> 1;
            place = place << 1;
        }

        return ans;
    }
}