class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer,Integer>map = new HashMap<>();
         List<Integer> ans = new ArrayList<>();
        for(int i =0;i<digits.length;i++){
            map.put(digits[i],map.getOrDefault(digits[i],0)+1);

        }
        for(int i =1;i<=9;i++){
          if (map.getOrDefault(i, 0) == 0)
    continue;
            map.put(i, map.get(i) - 1);
            for(int j =0;j<=9;j++){
                if (map.getOrDefault(j, 0) == 0)
    continue;
           map.put(j, map.get(j) - 1);
             for(int k =0;k<9;k+=2){
              if (map.getOrDefault(k, 0) == 0)
    continue;
            int number = i * 100 + j * 10 + k;
                    ans.add(number);
            }
                map.put(j, map.getOrDefault(j, 0) + 1);}
            map.put(i, map.getOrDefault(i, 0) + 1);
        
    }
        Collections.sort(ans);

    int[] result = new int[ans.size()];

for (int i = 0; i < ans.size(); i++) {
    result[i] = ans.get(i);
}

return result;

}}