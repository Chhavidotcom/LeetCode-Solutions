class Solution {
    public int dayOfYear(String date) {
           String x = date.substring(0,4);
        int num = Integer.parseInt(x);
        

        int[] arr={31,28,31,30,31,30,31,31,30,31,30,31};
         if((num %400==0)|| ((num %4==0)&&(num%100!=0)))
        arr[1]=29;
         String y = date.substring(8);
        int num2 = Integer.parseInt(y);
        int month = Integer.parseInt(date.substring(5,7));
         int sum = num2;
            for (int i = 0; i < month - 1; i++) {
            sum += arr[i];
        }
          return sum;
    }
}