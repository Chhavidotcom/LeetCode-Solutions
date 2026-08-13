class Solution {
    public int longestConsecutive(int[] nums) {
       HashMap<Integer,Boolean>map=new HashMap<>();
       int ans=0;
       for(int i=0;i<nums.length;i++){
        map.put(nums[i],true);

       }
       for(int x:map.keySet()){
        int ele=x-1;
        if(map.containsKey(ele)){
            map.put(x,false);
        }

       }
       for(int m:map.keySet()){
        int temp=1;
        if(map.get(m)==true){
            
            int num=m;
            while(map.containsKey(num+1)){
                num++;
                temp+=1;
                
            }
            if(temp>ans){
                ans=temp;
            }}
        
       } 
       return ans;
    }
}