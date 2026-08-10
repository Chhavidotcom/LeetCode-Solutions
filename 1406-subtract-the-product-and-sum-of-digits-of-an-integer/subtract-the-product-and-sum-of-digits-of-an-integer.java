class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int multiply=1;
        while(n!=0){
            int ld= n%10;
            sum = sum + ld;
            multiply = multiply*ld;
           n = n/10;
        }
        return multiply-sum;
    }
}