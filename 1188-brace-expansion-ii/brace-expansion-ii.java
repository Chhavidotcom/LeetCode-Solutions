class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, new int[]{0});

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> parse(String s, int[] index) {

        // Overall result of this expression
        Set<String> result = new HashSet<>();

        // Current concatenation result
        Set<String> current = new HashSet<>();
        current.add("");

        while (index[0] < s.length()
                && s.charAt(index[0]) != '}') {

            char ch = s.charAt(index[0]);

            // Union
            if (ch == ',') {

                result.addAll(current);

                current.clear();
                current.add("");

                index[0]++;
            }

            // Nested expression
            else if (ch == '{') {

                index[0]++; // skip '{'

                Set<String> inside = parse(s, index);

                index[0]++; // skip '}'

                current = concatenate(current, inside);
            }

            // Normal character
            else {

                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));

                current = concatenate(current, letter);

                index[0]++;
            }
        }

        // Add last concatenation group
        result.addAll(current);

        return result;
    }

    private Set<String> concatenate(
            Set<String> a,
            Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}