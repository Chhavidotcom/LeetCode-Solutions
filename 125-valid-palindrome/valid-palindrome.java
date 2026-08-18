class Solution {
    public boolean isPalindrome(String s) {
        String result = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                result = result + ch;
            }
        }
        String a= result.toLowerCase();
    
if(new StringBuilder(a).reverse().toString().equals(a)) {
    return true;
}
    return false;
    }
}