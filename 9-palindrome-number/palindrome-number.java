class Solution {
    public boolean isPalindrome(int x) {
        int value=x;
        int ld=0;
        int ans=0;
        if (x < 0) {
        return false;
    }

        while(x!=0){
            ld=x%10;
            ans=ans*10+ld;
            x=x/10;
        }
        if(ans==value){
            return true;
        }
        else 
        return false;
    }
}