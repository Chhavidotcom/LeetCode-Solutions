class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans =0;
      
        for(int j= left;j<=right;j++){
            int num =j;
              int count=0;
            while(num>0){
                int bit= num%2;
                if(bit==1){
                    count++;
                }
            num=num/2;
            }
        
        if(isPrime(count)){
            ans++;
        }}
return ans;

    }

        boolean isPrime(int n){
            if(n<2){
              return false;
            }
            for(int i=2;i*i<=n;i++)
            {
                if(n%i==0)
                {
                    return false;
                }
                
            }
return true;
        }
    }
