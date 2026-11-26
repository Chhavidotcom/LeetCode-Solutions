class Solution {
    public int lenLongestFibSubseq(int[] arr) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int max=0;
    
        for(int k =0;k<arr.length;k++){
            map.put(arr[k],k);
        }
        for(int i =0; i<arr.length-1;i++){   
            for(int j = i + 1; j < arr.length; j++) {
            int count=2;
            int a=arr[i];
            int b=arr[j];
           
                while(map.containsKey(a + b)) {
                    int c = a + b;
                    a = b;
                    b = c;
                    count++;
                }
                 max = Math.max(max, count);
        
        }}
        return max >= 3 ? max : 0;
    }
}