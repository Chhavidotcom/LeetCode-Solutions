class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int j =0;j<arr.length;j++){
            
         if (map.containsKey(2 * arr[j]) && map.get(2 * arr[j]) != j) {
    return true;
}
        }
        return false;
    }
}