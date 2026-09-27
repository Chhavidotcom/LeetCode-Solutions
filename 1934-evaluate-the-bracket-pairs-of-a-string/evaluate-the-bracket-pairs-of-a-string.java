class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        // knowledge ko HashMap mein store karo
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            // Normal character
            if (s.charAt(i) != '(') {
                ans.append(s.charAt(i));
                i++;
            }

            // Bracket pair
            else {
                i++; // '(' ko skip karo

                StringBuilder key = new StringBuilder();

                // ')' tak key collect karo
                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                // ')' ko skip karo
                i++;

                // Key ki value check karo
                if (map.containsKey(key.toString())) {
                    ans.append(map.get(key.toString()));
                } else {
                    ans.append("?");
                }
            }
        }

        return ans.toString();
    }
}