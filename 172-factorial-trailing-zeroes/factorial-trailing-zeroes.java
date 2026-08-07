class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        int demo=5;
        while(demo<=n){
            ans=ans +n/demo;
            demo =demo*5;
        }
        return ans;
    }
}