class Solution {
    public int fib(int n) {
        if(n==0||n==1){return n;}

     /*   int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        */

        int prev1=0;
        int prev2=1;
        int result=prev2;
        for(int i=2;i<=n;i++){
            result= prev1+prev2;
            prev1=prev2;
            prev2=result;
        }
        return result;
    }
}