class Solution {
    public String toHex(int num) {
      String ans="";
      if(num==0){
        return "0";
      }
    
      while(num!=0){
        int rem =num &15;
      
              if (rem < 10) {
                ans = (char)('0' + rem) + ans;
            } else {
                ans = (char)('A' + (rem - 10)) + ans;
            }
            num=num>>>4;
      }  
      ans = ans.toLowerCase();
      return ans;
      }
}