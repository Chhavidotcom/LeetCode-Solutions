class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>map1=new HashMap<>();
        for(int i=0;i<s.length();i++){
           map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
         HashMap<Character,Integer>map2=new HashMap<>();
        for(int j=0;j<t.length();j++){
           map2.put(t.charAt(j), map2.getOrDefault(t.charAt(j), 0) + 1);;
        }
        if (s.length()!=t.length())
        return false;

        for(Character ch:map1.keySet()){
            if(!map2.containsKey(ch))
            return false;
           if (!map1.get(ch).equals(map2.get(ch)))
        return false;
        }

return true;
    }
}