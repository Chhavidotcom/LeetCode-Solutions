class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int startAlice= countDays(arriveAlice);
        int endAlice = countDays(leaveAlice);
        int startBob= countDays(arriveBob);
        int endBob= countDays(leaveBob);

        int start= Math.max(startAlice,startBob);
        int end= Math.min(endAlice ,endBob);

        if(start>end)
        return 0;

        else
        return end-start+1;


    }
        public int countDays(String date)
        {
        int[] days={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month= Integer.parseInt(date.substring(0,2));
         int day= Integer.parseInt(date.substring(3));
        
        int ans =day;
        for(int i=0;i<month-1;i++){
            ans=ans+days[i];
        }
        return ans;

                }
    
}