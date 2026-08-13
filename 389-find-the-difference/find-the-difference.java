class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer>map= new HashMap<>();
       for(int i =0;i<s.length();i++){
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);        
       }
       for(int j =0;j<t.length();j++){
if (map.containsKey(t.charAt(j)))
{
    if(map.get(t.charAt(j))==1){
        map.remove(t.charAt(j));
    }
    else{
    map.put(t.charAt(j),(map.get(t.charAt(j))-1));}
}  
else{return t.charAt(j);}
     }
return t.charAt(0);

    }
}