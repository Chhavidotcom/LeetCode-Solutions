class Solution {
    public int maxProduct(int n) {
       int max1 = 0;
        int max2 = 0;

       while(n>0){
        int dg= n%10;
        n= n/10;

        if(dg>max1){
             max2 = max1;
                max1 = dg;
        }
         else if (dg > max2) {
                max2 = dg;
            }
        }

        return max1 * max2;
    }
}